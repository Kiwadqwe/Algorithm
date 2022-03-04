package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_최대힙_11279_S2 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 0){
                if(pq.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(pq.peek());
                    pq.remove();
                }
            }else{
                pq.add(a);
            }
        }
    }
}