import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_두용액_2470_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
//        System.out.println(twoPointer(N,array));
        int[] answer = binarySearch(array, N);

        System.out.println(array[answer[0]] +" "+array[answer[1]]);

    }

    private static int[] binarySearch(int[] array, int N) {

        int s,e,m,result = Integer.MAX_VALUE,hap;
        int[] answer = new int[2];

        for (int i = 0; i < N-1; i++) {
            s = i+1;
            e = N-1;

            while( s <= e ){
                m = (s+e) / 2;
                hap = Math.abs(array[m]+array[i]);

                if(hap < result){
                    result = hap;
                    answer[0] = i;
                    answer[1] = m;

                    if(result == 0){
                        return answer;
                    }

                    if((i+1<=m && m<N-1) && (Math.abs(array[m+1]+array[i]) < Math.abs(array[i]+array[m-1]))){
                        s = m+1;
                    }else{
                        e = m-1;
                    }
                }else{
                    if((i+1<=m && m<N-1) && (Math.abs(array[m+1]+array[i]) < Math.abs(array[i]+array[m-1]))){
                        s = m+1;
                    }else{
                        e = m-1;
                    }
                }
            }
        }
        return answer;
    }

    public static String twoPointer(int N, int[] array){
        int s = 0, e = N-1, hap, result = Integer.MAX_VALUE;
        int start = 0 ,end = 0;

        while(s < e){
            hap = array[s]+array[e];

            if(Math.abs(hap) < Math.abs(result)){
                result = hap;
                start = array[s];
                end = array[e];
            }

            if(hap == 0 ) break;

            if(0 < hap) {
                e--;
            }else{
                s++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(start).append(" ").append(end);

        return sb.toString();
    }
}
