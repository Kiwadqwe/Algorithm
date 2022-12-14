import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_가운데를말해요_1655_G2 {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static List<Integer> result = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int x = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());

            if(maxHeap.size() == minHeap.size()){
                maxHeap.add(-x);
            }else{
                minHeap.add(x);
            }

            if((!minHeap.isEmpty() && !maxHeap.isEmpty()) && minHeap.peek() < -maxHeap.peek()){
                int a = maxHeap.poll();
                int b = minHeap.poll();
                maxHeap.add(-b);
                minHeap.add(-a);
            }

            if(!maxHeap.isEmpty()) {
                result.add(-maxHeap.peek());
            }
        }
        for(Integer i : result){
            System.out.println(i);
        }
    }

}