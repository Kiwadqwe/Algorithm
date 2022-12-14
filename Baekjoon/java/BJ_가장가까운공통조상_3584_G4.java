import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_가장가까운공통조상_3584_G4 {
    static int T,N;
    static int[] p;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        int x,y = 0;
        int a,b = 0;

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            p = new int[N+1];

            for (int i = 0; i < N-1; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                p[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            result.add(lca(x,y));
        }

        for(Integer i: result){
            System.out.println(i);
        }
    }

    public static int lca(int x, int y){
        boolean[] visited = new boolean[N+1];

        while(x != 0){
            visited[x] = true;
            x = p[x];
        }

        while(y != 0){
            if(visited[y]) return y;
            y = p[y];
        }

        return 0;
    }
}
