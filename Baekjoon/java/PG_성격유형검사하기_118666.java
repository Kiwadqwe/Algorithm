import java.io.IOException;
import java.util.*;

public class PG_성격유형검사하기_118666 {

    public static void main(String[] args) throws IOException {

//        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }

    public static String solution(String[] survey, int[] choices){
        List<Character> answer = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        int[] score = new int[]{0,3,2,1,0,1,2,3};
        char[] array = new char[]{'R','T','C','F','J','M','A','N'};

        for (int i = 0; i < array.length; i++) {
            map.put(array[i],0);
            }

        int l = survey.length;
        char a,b;
        for (int i = 0; i < l; i++) {
            a = survey[i].charAt(0);
            b = survey[i].charAt(1);

            if(choices[i] < 4){
                map.put(a,map.get(a)+score[choices[i]]);
            }else if(4 < choices[i]){
                map.put(b,map.get(b)+score[choices[i]]);
            }
        }

        check('R','T',map,answer);
        check('C','F',map,answer);
        check('J','M',map,answer);
        check('A','N',map,answer);
        StringBuilder sb = new StringBuilder();

        for(char c: answer){
            sb.append(c);
        }

        return sb.toString();
    }

    private static void check(char x, char y, Map<Character, Integer> map, List<Character> answer) {

        if(map.get(x) < map.get(y)){
            answer.add(y);
        }else{
            answer.add(x);
        }
    }

}
