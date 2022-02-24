package baekjoon_r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_나무재테크_16235_G4 {
    static int N,M,K,result;
    static int[][] array;
    static List<Point> list = new ArrayList<>();
    static int[] dx = {-1,-1,-1,0,1,1,1,0};
    static int[] dy = {-1,0,1,1,1,0,-1,-1};

    public static class Point implements Comparable<Point>{
        int x,y,z;

        public Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Point p) {
            return z - p.z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            list.add(new Point(x,y,z));
        }
        for (int i = 0; i < K; i++) {
            go();
        }
        spring();
        tree();
        System.out.println(result);
    }

    private static void tree() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(0 < array[i][j]){
                    result+=1;
                }
            }
        }
    }

    private static void go() {
    }


    private static void winter() {
    }

    private static void fall() {
    }

    private static void summer() {
    }

    private static void spring() {
        for (int i = 0; i < list.size(); i++) {
            array[list.get(i).x][list.get(i).y] += list.get(i).z;
            int old = list.get(i).z;
            old++;
            list.set(i, new Point(list.get(i).x,list.get(i).y,old));
        }

    }
}
