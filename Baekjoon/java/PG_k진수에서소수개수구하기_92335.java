import java.util.ArrayList;
import java.util.List;

public class PG_k진수에서소수개수구하기_92335 {

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k){
        int answer = 0;
        String t;

        if(k != 10){
            t = go(n,k);
        }else{
            t = String.valueOf(n);
        }

        List<String> list = List.of(t.split("0"));;

        for(String a : list){
            if(0 < a.length() && !a.equals("1") && cal(Long.parseLong(a))){
                answer++;
            }
        }

        return answer;
    }

    private static boolean cal(long n) {
        for (int i = 2; i < ((int)Math.sqrt(n))+1; i++) {
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }

    private static String go(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(true){
            if(n < k){
                sb.insert(0,n);
                return sb.toString();

            }

            int t = n % k;
            sb.insert(0, t);
            n/=k;
        }
    }
}
