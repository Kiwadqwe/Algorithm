package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_마법상어와파이어볼_20056_G4 {
    static int N,M,K;
    static List<Point> fire,temp;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static List<Point>[][] array;
    static boolean[][] visited;

    public static class Point {
        int x,y,m,s,d;

        public Point(int x, int y, int m, int s, int d){
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new ArrayList[N][N];
        fire = new ArrayList<>();
        temp = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fire.add(new Point(r,c,m,s,d));
        }
        for (int i = 0; i < K; i++) {
            move();
        }
        int result = 0;
        for (int i = 0; i < fire.size(); i++) {
            result += fire.get(i).m;
        }
        System.out.println(result);
    }

    private static void move(){
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<fire.size(); i++){
            int rx = (N + dx[fire.get(i).d] * (fire.get(i).s % N)) % N;
            int ry = (N + dy[fire.get(i).d] * (fire.get(i).s % N)) % N;
            int nx = (fire.get(i).x + rx) % N;
            int ny = (fire.get(i).y + ry) % N;

            fire.set(i,new Point(nx,ny,fire.get(i).m,fire.get(i).s,fire.get(i).d));
            array[nx][ny].add(fire.get(i));
        }

        for (int i = 0; i < fire.size(); i++) {
            search(fire.get(i).x,fire.get(i).y,i);
        }

        fire.clear();
        fire.addAll(temp);
        temp.clear();
    }

    private static void search(int x, int y,int i){
        int size = array[x][y].size();
        int c = 0,m = 0,s = 0;

        if(2 <= size){
            if(!visited[x][y]){
                visited[x][y] = true;
                for (int k = 0; k < size; k++) {
                    m += array[x][y].get(k).m;
                    s += array[x][y].get(k).s;
                    if(array[x][y].get(k).d % 2 == 0){
                        c+=1;
                    }
                }

                m/=5;
                s/=size;
                if(m == 0) return;
                if(c == size || c == 0){
                    for (int k = 0; k <= 6; k+=2) {
                        temp.add(new Point(x,y,m,s,k));
                    }
                }else{
                    for (int k = 1; k <= 7; k+=2) {
                        temp.add(new Point(x,y,m,s,k));
                    }
                }
            }
        }else{
            temp.add(fire.get(i));
        }
    }
}