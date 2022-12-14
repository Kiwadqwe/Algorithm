import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_가장긴증가하는부분수열_11053_S2 {
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
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }else if(A[i] == A[j]){
                    dp[i] = dp[j];
                }
            }
        }

        Arrays.sort(dp);

        return dp[N];
    }
}
