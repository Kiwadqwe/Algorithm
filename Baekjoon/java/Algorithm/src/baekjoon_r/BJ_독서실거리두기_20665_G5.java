package baekjoon_r;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_독서실거리두기_20665_G5 {
    static int N, T, P, time = 720;
    static List<Point> array;
    static boolean[][] visited;

    public static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if (point.x != this.x) {
                return this.x - point.x;
            }
            return this.y - point.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        array = new ArrayList<>();
        visited = new boolean[1261][N+1];
        for(int i=0; i<T; i++){
            String s = br.readLine();
            String ipu = s.split(" ")[0];
            String out = s.split(" ")[1];

            int itime = Integer.parseInt(ipu.substring(0,2)) * 60 + Integer.parseInt(ipu.substring(2,4));
            int otime = Integer.parseInt(out.substring(0,2)) * 60 + Integer.parseInt(out.substring(2,4));
            array.add(new Point(itime,otime));
        }
        array = array.stream().sorted().collect(Collectors.toList());

        go();

        int result = 0;
        for (int i = 540; i < 1260; i++) {
            if(!visited[i][P]){
                result++;
            }
        }

        System.out.println(result);
    }

    private static void go(){
        for (int i = 0; i < T; i++) {
            int start = array.get(i).x;
            int end = array.get(i).y;

            int s = seat(start);

            for (int j = start; j < end; j++) {
                visited[j][s] = true;
            }
        }
    }

    private static int seat(int t){
        int maxSeat = 0;
        int s = 0;

        for (int i = 1; i <= N; i++) {
            // 비어 있는 좌석
            if(!visited[t][i]){
                int d = distance(t,i);
                // 나랑 가까운 사람 중에서 가장 멀리 앉을 수 있는곳
                if(maxSeat < d){
                    maxSeat = d;
                    s = i;
                }
            }
        }
        return s;
    }

    private static int distance(int t, int s){
        int minSeat = 110;

        for (int i = 1; i <= N; i++) {
            // 좌석이 같은 경우빼고
            if(i == s) continue;
            // 현재 좌석에 앉아있음
            if(visited[t][i]){
                // 가장 먼 좌석에서 좌석번호가 가장 작은 자리
                int d = Math.abs(i-s);
                minSeat = Math.min(d,minSeat);
            }
        }
        return minSeat;
    }
}
