package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_마법상어와비바라기_21610_G5 {
    static int N,M,result,cnt;
    static int[][] array,tp;
    static List<Cloud> move = new ArrayList<>();
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static List<Point> temp = new ArrayList<>();
    static List<Point> cloud = new ArrayList<>();
    static int[] mx;
    static int[] my;

    public static class Point {
        int x,y,r;

        public Point(int x, int y, int r){
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public static class Cloud {
        int d,m;

        public Cloud(int d, int m){
            this.d = d;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N][N];
        tp = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            move.add(new Cloud(d,s));
        }
        // 초기 비구름
        mx = new int[]{N - 2, N - 2, N - 1, N - 1};
        my = new int[]{0, 1, 0, 1};

        for (int i = 0; i < move.size(); i++) {
            go(i);
            mx = new int[cloud.size()];
            my = new int[cloud.size()];

            // 변경된 비구름
            for (int j = 0; j < cloud.size(); j++) {
                mx[j] = cloud.get(j).x;
                my[j] = cloud.get(j).y;
            }

            cloud.clear();
        }
        all();
        System.out.println(result);
    }

    private static void go(int c){
        // 비구름 이동
        int rx = (N + dx[move.get(c).d] * (move.get(c).m % N)) % N;
        int ry = (N + dy[move.get(c).d] * (move.get(c).m % N)) % N;
        for (int i = 0; i < mx.length; i++) {
            int nx = (mx[i]+rx) % N;
            int ny = (my[i]+ry) % N;
            array[nx][ny] += 1;
            temp.add(new Point(nx, ny, array[nx][ny]));
        }

        for (int i = 0; i < N; i++) {
            System.arraycopy(array[i], 0, tp[i], 0,tp[i].length);
        }

        for (int i = 0; i < temp.size(); i++) {
            int x = temp.get(i).x;
            int y = temp.get(i).y;
            dCheck(x,y);
            // 비구름이 있었던 자리를 제외하고 비구름이 생성되므로 0 처리
            tp[x][y] = 0;

            // 한꺼번에 올리기 위해서 재저장
            temp.set(i,new Point(x,y,temp.get(i).r+cnt));
        }

        // 2이상인 좌표 -2 처리
        search();

        // -2 비구름 처리 후 전에 비구름이였던 자리 값 채워주기
        for (Point point : temp) {
            array[point.x][point.y] = point.r;
        }

        temp.clear();

    }
    private static void dCheck(int x, int y){
        cnt = 0;
        for (int i = 1; i < 8; i+=2) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(0<=nx && nx<N && 0<=ny && ny<N){
                // 현재 구름 위치의 대각선값 확인
                if(array[nx][ny] != 0){
                    // 한꺼번에 올리기 위해서 카운트 처리
                    cnt++;
                }
            }
        }
    }

    private static void search(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(2 <= tp[i][j]){
                    array[i][j] -= 2;
                    // 옮겨진 비구름의 자리 다시 셋팅
                    cloud.add(new Point(i,j,array[i][j]));
                }
            }
        }
    }

    private static void all() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += array[i][j];
            }
        }
    }
}