import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_데스나이트_16948_S1 {
    static List<Point> list = new ArrayList<>();
    static int[] dx = {-2,-2,0,0,2,2};
    static int[] dy = {-1,1,-2,2,-1,1};

    public static class Point{
        int cnt,x,y;

        public Point(int cnt, int x, int y){
            this.cnt = cnt;
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));


        System.out.println(solution(N));
    }

    public static int solution(int N){
        return bfs(N);
    }

    private static int bfs(int N) {
        Queue<Point> pq = new LinkedList<>();
        pq.add(new Point(0,list.get(0).x,list.get(0).y));
        boolean[][] visited = new boolean[N][N];

        while(!pq.isEmpty()){
            Point p = pq.poll();

            if(p.x == list.get(1).x && p.y == list.get(1).y){
                return p.cnt;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if((0<=nx && nx<N && 0<=ny && ny<N)
                && !visited[nx][ny]){
                    pq.add(new Point(p.cnt+1,nx,ny));
                    visited[nx][ny] = true;
                }
            }

        }

        return -1;
    }
}
