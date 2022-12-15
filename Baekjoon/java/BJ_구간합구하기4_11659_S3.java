import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_구간합구하기4_11659_S3 {
    static List<Point> list = new ArrayList<>();
    
    public static class Point {
        int x,y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        System.out.println(solution(N,M,array));
    }

    public static String solution(int N, int M,int[] array){
        int answer = 0;

        int[] dp = new int[N+1];

        for (int i = 0; i < N; i++) {
            dp[i+1] = dp[i]+array[i];
        }

        StringBuilder sb = new StringBuilder();

        for(Point p : list) {
            sb.append(dp[p.y] - dp[p.x - 1]).append("\n");
        }

        return sb.toString();
    }
}
