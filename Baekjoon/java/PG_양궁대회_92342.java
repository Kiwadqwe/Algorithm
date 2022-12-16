import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PG_양궁대회_92342 {
    static int[] answer;
    static int result;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0})));
        System.out.println(Arrays.toString(solution(1, new int[]{1,0,0,0,0,0,0,0,0,0,0})));
    }

    public static int[] solution(int N, int[] info){
        answer = new int[]{-1,0,0,0,0,0,0,0,0,0,0};
        List<Integer> list = new ArrayList<>();

        for(int i : info){
            list.add(i);
        }
        Collections.reverse(list);

        dfs(N,list,0,0,new int[N]);

        List<Integer> result = new ArrayList<>();

        for(int i: answer){
            result.add(i);
        }
        Collections.reverse(result);

        answer = new int[11];
        if(result.get(10) == -1){
            return new int[]{-1};
        }else{
            for (int i = 0; i < 11; i++) {
                answer[i] = result.get(i);
            }
            return answer;
        }
    }


    private static void dfs(int R,List<Integer> info, int start, int idx, int[] lion) {
        if(idx == R){
            check(lion,info);
            return;
        }

        for (int i = start; i < 11; i++) {
            lion[idx] = i;
            dfs(R,info,i,idx+1,lion);
        }
    }

    private static void check(int[] lion, List<Integer> info) {
        int[] a = new int[11];
        int lHap = 0,aHap = 0;

        for (int i = 0; i < lion.length; i++) {
            a[lion[i]]++;
        }

        for (int i = 0; i < 11; i++) {
            if(info.get(i) == 0 && a[i] == 0) continue;

            if(info.get(i) < a[i]){
                lHap+=i;
            }else{
                aHap+=i;
            }
        }

        if(aHap < lHap){
            int l = lHap-aHap;
            if(result < l){
                result = l;
                answer = a;
            }
        }
    }
}
