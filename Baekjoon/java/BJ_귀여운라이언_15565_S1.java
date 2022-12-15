import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_귀여운라이언_15565_S1 {
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

        System.out.println(solution(N,M,array));
    }

    public static int solution(int N, int M, int[] array){
        int answer = Integer.MAX_VALUE;

        int s = 0;
        int e = 0;
        int cnt = 0;

        if(array[e] == 1){
            cnt++;
        }

        while(s <= e){
            if(cnt < M && e < N-1){
                e++;
                if(array[e] == 1) cnt++;
            }else{
                if(cnt == M) answer = Math.min(answer,e-s+1);
                if(array[s] == 1) cnt--;
                s++;
            }
        }

        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        return answer;
    }
}
