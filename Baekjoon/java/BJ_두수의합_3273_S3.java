import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_두수의합_3273_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(solution(N,M,array));
    }

    public static int solution(int N,int M, int[] array){
        int answer = 0;

        Arrays.sort(array);

        int s = 0, e = N-1, hap;

        while(s < e){
            hap = array[s]+array[e];
            if(hap == M){
                answer++;
                s++;
                e--;
            }
            else if(hap > M){
                e--;
            }else {
                s++;
            }
        }


        return answer;
    }
}
