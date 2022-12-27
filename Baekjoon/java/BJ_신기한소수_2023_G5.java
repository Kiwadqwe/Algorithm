import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_신기한소수_2023_G5 {
    static int N;
    static char[] a = new char[]{'2','3','5','7'};
    static char[] b = new char[]{'1','3','7','9'};
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(char i: a){
            dfs(String.valueOf(i));
        }
        for(String i: result){
            System.out.println(i);
        }
    }

    private static void dfs(String n){
        for (int i = 2; i < (int) Math.sqrt(Integer.parseInt(n))+1; i++) {
            if(Integer.parseInt(n) % i == 0){
                return;
            }
        }

        if(n.length() == N){
            result.add(n);
            return;
        }

        for(char i: b){
            dfs(n+i);
        }

    }
}
