package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_마법사상어와파이어스톰_20058_G4 {
    static int N,Q,result,max;
    static int[][] array,temp;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static List<Integer> magic = new ArrayList<>();
    static boolean[][] visited;

    public static class Point{
        int x,y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2,N);

        array = new int[N][N];
        temp = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            magic.add(Integer.parseInt(st.nextToken()));
        }

        move();
        hap();
        ice();
        System.out.println(result);
        System.out.println(max);
    }

    private static void ice(){
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && 0 < array[i][j]){
                    max = Math.max(max,bfs(i,j));
                }
            }
        }
    }

    private static int bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        int count = 1;

        while(!q.isEmpty()){
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<N){
                    if(!visited[nx][ny] && 0 < array[nx][ny]){
                        count++;
                        visited[nx][ny] = true;
                        q.add(new Point(nx,ny));
                    }
                }
            }
        }

        return count;
    }

    private static void hap(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(array[i][j] <=0) continue;
                result+=array[i][j];
            }
        }
    }

    private static void move(){
        for (Integer m : magic) {
            int L = (int) Math.pow(2,m);
            if(L != 1){
                for (int i = 0; i < N; i += L) {
                    for (int j = 0; j < N; j += L) {
                        rotation(i, j, L);
                    }
                }
            }

            search();
        }
    }

    private static void search() {
        boolean[][] sear = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(array[i][j] == 0) continue;
                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(0<=nx && nx<N && 0<=ny && ny<N){
                        if(0 < array[nx][ny]){
                            count++;
                        }
                    }
                }

                if(count < 3){
                    sear[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(sear[i][j]){
                    array[i][j]--;
                }
            }
        }
    }

    private static void rotation(int x, int y, int L){
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                temp[j][L-i-1] = array[x+i][y+j];
            }
        }

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                array[x+i][y+j] = temp[i][j];
            }
        }
    }
}