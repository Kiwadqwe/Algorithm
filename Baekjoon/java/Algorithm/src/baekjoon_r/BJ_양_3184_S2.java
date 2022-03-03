package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_양_3184_S2 {
    static int R,C,oo,vv,o,v;
    static char[][] array;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static class Point {
        int x,y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        array = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            array[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(!visited[i][j]){
                    if(array[i][j] == 'v'){
//                        bfs(i,j,0,1);
                        o = 0;
                        v = 0;
                        dfs(i,j);
                        go(o,v);
                    }else if(array[i][j] == 'o'){
//                        bfs(i,j,1,0);
                        o = 0;
                        v = 0;
                        dfs(i,j);
                        go(o,v);
                    }
                }
            }
        }
        System.out.println(oo+" "+vv);
    }

    private static void go(int o, int v){
        if(o <= v){
            vv+= v;
        }else{
            oo+= o;
        }
    }

    private static void dfs(int x, int y){
        visited[x][y] = true;
        if(array[x][y] == 'v') v++;
        else if(array[x][y] == 'o') o++;

        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(0<=nx && nx<R && 0<=ny && ny<=C){
                if(!visited[nx][ny]){
                    if(array[nx][ny] != '#'){
                        visited[nx][ny] = true;
                        dfs(nx,ny);
                    }
                }
            }
        }
    }

//    private static void bfs(int x, int y, int o, int v){
//        Queue<Point> q = new LinkedList<>();
//        q.add(new Point(x,y));
//        visited[x][y] = true;
//
//        while(!q.isEmpty()){
//            Point p = q.poll();
//
//            for (int i = 0; i < 4; i++) {
//                int nx = p.x+dx[i];
//                int ny = p.y+dy[i];
//
//                if(0<=nx && nx<R && 0<=ny && ny<C){
//                    if(!visited[nx][ny]){
//                        if(array[nx][ny] == 'v'){
//                            q.add(new Point(nx,ny));
//                            v++;
//                            visited[nx][ny] = true;
//                        }else if(array[nx][ny] == 'o'){
//                            q.add(new Point(nx,ny));
//                            o++;
//                            visited[nx][ny] = true;
//                        }else if(array[nx][ny] == '.'){
//                            q.add(new Point(nx,ny));
//                            visited[nx][ny] = true;
//                        }
//                    }
//                }
//            }
//        }
//
//        if(o <= v){
//            vv+= v;
//        }else{
//            oo+= o;
//        }
//
//    }
}
