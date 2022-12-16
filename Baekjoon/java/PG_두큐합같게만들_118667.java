import java.util.LinkedList;
import java.util.Queue;

public class PG_두큐합같게만들_118667 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solution(new int[]{1, 1}, new int[]{1,5}));
    }

    public static int solution(int[] queue1, int[] queue2){
        int answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long q1Sum = 0;
        long q2Sum = 0;

        for(int a: queue1) {
            q1.add(a);
            q1Sum+=a;
        }
        for(int a: queue2) {
            q2.add(a);
            q2Sum+=a;
        }

        int l = queue1.length * 3;

        while((!q1.isEmpty() && !q2.isEmpty()) && answer != l){
            if(q1Sum == q2Sum){
                return answer;
            }else if(q1Sum < q2Sum){
                Integer p = q2.poll();
                q1Sum+=p;
                q2Sum-=p;
                q1.add(p);
            }else{
                Integer p = q1.poll();
                q1Sum-=p;
                q2Sum+=p;
                q2.add(p);
            }
            answer++;
        }

        return -1;
    }
}
