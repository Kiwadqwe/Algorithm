import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_배열합치기_11728_S5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                array.add(Integer.valueOf(st.nextToken()));
            }
        }

        Collections.sort(array);
        StringBuilder sb = new StringBuilder();
        for(Integer a : array){
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }

}
