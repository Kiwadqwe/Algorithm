import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_가장큰증가부분수열_11055_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N+1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N,A));
    }

    public static int solution(int N, int[] A){
        int[] dp = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < i; j++) {
                if(A[j] < A[i]){
                    dp[i] = Math.max(dp[i],dp[j]+A[i]);
                }
            }
        }
        Arrays.sort(dp);

        return dp[N];
    }
}

