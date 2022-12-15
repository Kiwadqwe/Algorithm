import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_뒤집기_1439_S5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] chars = st.nextToken().toCharArray();

        System.out.println(solution(chars));
    }

    public static int solution(char[] c){
        int z = 0, o = 0;
        if(c[0] == '0'){
            z++;
        }else{
            o++;
        }

        for (int i = 1; i < c.length ; i++) {
            if(c[i] == '0' && c[i-1] != c[i]){
                z++;
            }else if(c[i] == '1' && c[i-1] != c[i]){
                o++;
            }
        }

        return Math.min(z,o);
    }
}
