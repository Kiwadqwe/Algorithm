import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_겹치는건싫어_20922_S2 {
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        m = 0;

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            m = Math.max(m,a);
            A[i] = a;
        }

        System.out.println(solution(N,K,A));
    }

    public static int solution(int N,int K, int[] array){
        int answer = 0;
        int[] n = new int[m+1];
        int s = 0;
        int e = 0;

        while(e < N){
            if(K <= n[array[e]]){
                n[array[s]]--;
                s++;
            }else {
                n[array[e]]++;
                e++;
            }

            answer = Math.max(answer,e-s);
        }

        return answer;
    }

}
