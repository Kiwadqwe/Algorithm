package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_특정거리의도시찾기_18352_S2 {
    static int N,M,K,X,cnt;
    static List<Integer>[] array;
    static boolean[] visited,check;
    static StringBuilder sb;
    static List<Integer> list = new ArrayList<>();

    public static class Point{
        int x,cnt;

        public Point(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;

        check = new boolean[N];
        array = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            array[a].add(b);
        }

        go();
        if(list.isEmpty()){
            System.out.println(-1);
        }else{
            list.stream().sorted()
                    .forEach(System.out::println);
        }
    }

    private static void go(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(X,0));
        visited = new boolean[N];
        visited[X] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.cnt == K) list.add(p.x+1);

            for (int i = 0; i < array[p.x].size(); i++) {
                int x =  array[p.x].get(i);
                if(!visited[x]){
                    q.add(new Point(x,p.cnt+1));
                    visited[x] = true;
                }
            }
        }
    }
}