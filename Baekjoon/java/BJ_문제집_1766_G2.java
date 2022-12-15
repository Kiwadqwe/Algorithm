import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_문제집_1766_G2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N+1];
        List<Integer>[] array= new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a].add(b);
            indegree[b] += 1;
        }

        System.out.println(solution(N,array,indegree));
    }

    public static String solution(int N, List<Integer>[] array,int[] indegree){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < N+1; i++) {
            if(indegree[i] == 0){
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now).append(" ");

            for(Integer a : array[now]){
                indegree[a] -=1;
                if(indegree[a] == 0){
                    pq.add(a);
                }
            }
        }

        return sb.toString();
    }
}
