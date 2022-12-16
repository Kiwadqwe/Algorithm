import java.util.HashMap;
import java.util.Map;

public class PG_키패드누르기_62756 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},"left"));
    }
    public static String solution(int[] numbers, String hand){
        StringBuilder answer = new StringBuilder();

        int[] left = new int[]{3,0};
        int[] right = new int[]{3,2};

        Map<Integer,int[]> map = Map.of(
                1,new int[]{0,0},
                2,new int[]{0,1},
                3,new int[]{0,2},
                4,new int[]{1,0},
                5,new int[]{1,1},
                6,new int[]{1,2},
                7,new int[]{2,0},
                8,new int[]{2,1},
                9,new int[]{2,2},
                0,new int[]{3,1}
        );

        for(int n: numbers){
            if(n == 1 || n == 4 || n == 7){
                left = map.get(n);
                answer.append("L");
            }else if (n == 3 || n == 6 || n == 9){
                right = map.get(n);
                answer.append("R");
            }else {
                int x = Math.abs(map.get(n)[0]-left[0])+Math.abs(map.get(n)[1]-left[1]);
                int y = Math.abs(map.get(n)[0]-right[0])+Math.abs(map.get(n)[1]-right[1]);

                if(x < y){
                    left = map.get(n);
                    answer.append("L");
                }else if(y < x){
                    right = map.get(n);
                    answer.append("R");
                }else {
                    if(hand.equals("right")){
                        right = map.get(n);
                        answer.append("R");
                    }else{
                        left = map.get(n);
                        answer.append("L");
                    }
                }
            }
        }

        return answer.toString();
    }
}
