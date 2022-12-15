import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BJ_두개의탑_2118_G5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(solution(N,array));
        System.out.println(twoPointer(N,array));
    }

    private static int twoPointer(int n, int[] array) {
        int answer = 0;

        int s = 0,e = 1,a,b;
        a = array[0];
        b = IntStream.of(array).sum() - a;

        while(e < n){
            answer = Math.max(answer,Math.min(a,b));

            if(a < b){
                a += array[e];
                b -= array[e];
                e++;
            }else{
                a -= array[s];
                b += array[s];
                s++;
            }
        }

        return answer;

    }

    public static int solution(int N, int[] array){
        int answer = 0;

        int s,e,m,a,b;

        for (int i = 1; i < N; i++) {
            s = i;
            e = N;

            while(s <= e){
                m = (s+e) / 2;
                a = array[m] - array[i-1];
                b = array[N] - a;

                if(a < b){
                    s = m+1;
                }else{
                    e = m-1;
                }

                answer = Math.max(answer,Math.min(a,b));

            }
        }

        return answer;
    }
}
