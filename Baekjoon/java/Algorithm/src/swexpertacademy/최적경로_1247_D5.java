package swexpertacademy;

import java.io.*;
import java.util.*;
 
public class 최적경로_1247_D5 {
    static int N,result,tp;
    static Point[] company,house, customer;
     
    public static class Point{
        int x,y;
        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
         
        int TC = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
             
            company = new Point[1];
            house = new Point[1];
            customer = new Point[N];
            st = new StringTokenizer(br.readLine());
            company[0] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            house[0] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
             
            for (int i = 0; i < N; i++) {
                customer[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
//          for (int i = 0; i < customer.length; i++) {
//              System.out.println(customer[i].x + " "+ customer[i].y);
//          }
             
            result = Integer.MAX_VALUE;
            permu(N,new int[N],new int[N],new boolean[N]);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
 
    private static void permu(int idx, int[] choosed,int[] choosed2, boolean[] visited) {
        if(idx == 0) {
//          System.out.println(Arrays.toString(choosed));
//          System.out.println(Arrays.toString(choosed2));
          
            go(choosed,choosed2);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                choosed[choosed.length-idx] = customer[i].x;
                choosed2[choosed.length-idx] = customer[i].y;
                permu(idx-1,choosed,choosed2,visited);
                visited[i] = false;
            }
        }
    }
 
    private static void go(int[] choosed, int[] choosed2) {
        // 회사에서 첫 고객과의 거리
        tp = Math.abs(company[0].x-choosed[0])+Math.abs(company[0].y-choosed2[0]);
        int x = choosed[0];
        int y = choosed2[0];
         
        // 고객들과의 거리
        for (int i = 1; i < N; i++) {
            tp += Math.abs(x-choosed[i])+Math.abs(y-choosed2[i]);
            x = choosed[i];
            y = choosed2[i];
        }
         
        // 마지막 고객과 집까지의 거리
        tp += Math.abs(house[0].x-x)+Math.abs(house[0].y-y);
        result = Math.min(tp, result);
    }
}