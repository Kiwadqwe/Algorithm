package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_뱀_3190_G5 {
    static int N,K,L;
    static int[][] array;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static List<director> list = new ArrayList<>();
    static snake sn = new snake(0,0);

    public static class snake{
        int x;
        int y;

        public snake(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static class director{
        int t;
        char d;

        public director(int t, char d){
            this.t = t;
            this.d = d;
        }
    }
    public static class Point{
        int x;
        int y;
        int time;

        public Point(int x, int y,int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        array = new int[N][N];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            array[a][b] = 1;
        }
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            list.add(new director(a,c));
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,0));
        int mx = 1;
        int my = 1;
        Deque<snake> snakes = new ArrayDeque<>();
        snakes.addFirst(new snake(0,0));

        while(!q.isEmpty()){
            Point p = q.poll();

            // 방향 전환
            if(!list.isEmpty()){
                for(director d : list){
                    if(p.time == d.t){
                        if(d.d == 'D'){
                            mx = (mx+1)%4;
                            my = (my+1)%4;
                        }else if(d.d == 'L'){
                            mx = (mx-1)%4;
                            my = (my-1)%4;
                            if(mx < 0 || my < 0){
                                mx = 3;
                                my = 3;
                            }
                        }
                        list.remove(0);
                        break;
                    }
                }
            }

            int nx = p.x+dx[mx];
            int ny = p.y+dy[my];

            // 뱀의 머리가 몸에 닿을 경우
            for(snake s : snakes){
                if(nx == s.x && ny == s.y){
                    return p.time+1;
                }
            }

            // 뱀의 머리가 벽에 부딪힐 경우
            if(0<=nx && nx<N && 0<=ny && ny<N){
                if(array[nx][ny] == 1){
                    array[nx][ny] = 0;
                }else{
                    snakes.removeFirst();
                }

                // 뱀의 머리 이동
                snakes.addLast(new snake(nx,ny));
                q.add(new Point(nx,ny,p.time+1));
            }else{
                return p.time+1;
            }
        }

        return 0;
    }
}