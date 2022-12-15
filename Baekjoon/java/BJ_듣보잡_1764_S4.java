import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_듣보잡_1764_S4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] list = new String[N];
        List<String> list2 = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = st.nextToken();
        }
        Arrays.sort(list);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(0 <= Arrays.binarySearch(list,s)){
                list2.add(s);
            }
        }

        Collections.sort(list2);

        System.out.println(list2.size());
        for(String l: list2){
            System.out.println(l);
        }
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            map.put(st.nextToken(),0);
//        }
//        List<String> solution = solution(list, map);
//        System.out.println(solution.size());
//
//        for(String s :solution){
//            System.out.println(s);
//        }
    }

    public static List<String> solution(List<String> map, Map<String,Object> map2){

        List<String> result = new ArrayList<>();

        for (int i = 0; i < map.size(); i++) {
            if(map2.containsKey(map.get(i))){
                result.add(map.get(i));
            }
        }

        Collections.sort(result);
        return result;
    }
}
