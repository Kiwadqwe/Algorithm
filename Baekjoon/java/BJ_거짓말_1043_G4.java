import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_거짓말_1043_G4 {
    static int[] p;
    static int N,M,K;
    static List<Integer>[] party;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        party = new ArrayList[M+1];

        for (int i = 0; i < N+1; i++) {
            p[i] = i;
        }
        for (int i = 0; i < M+1; i++) {
            party[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        int t = 0;

        if(0 < K){
            for (int i = 0; i < K; i++) {
                t = Integer.parseInt(st.nextToken());
                list.add(t);
                p[t] = 0;
            }
            ipu(br);
        }else{
            ipu(br);
        }
        int answer = 0;

        if(list.isEmpty()){
            answer = M;
        }else{
            int s = find(list.get(0));
            for (int i = 1; i < M+1; i++) {
                if(check(s,party[i])){
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean check(int s, List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            // 알고있는 사람이 포함되지 않은 경우
            if (find(array.get(i)) != s)
                return true;
        }
        return false;
    }

    private static void ipu(BufferedReader br) throws IOException {
        StringTokenizer st;
        int t;

        for (int i = 1; i < M+1; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens())
                party[i].add(Integer.parseInt(st.nextToken()));

            for (int j = 0; j < party[i].size() - 1; j++)
                union(party[i].get(j), party[i].get(j + 1));
        }
    }

    public static int find(int x){
        if(x != p[x]){
            p[x] = find(p[x]);
        }

        return p[x];
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if( x < y ){
            p[y] = x;
        }else {
            p[x] = y;
        }
    }
}
