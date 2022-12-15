import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_미로만들기_2665_G4 {

    public static class Point implements Comparable<Point>{
        int cnt,x,y;

        public Point(int cnt, int x,int y){
            this.cnt = cnt;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            return this.cnt-point.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char[][] array = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = st.nextToken().toCharArray();
        }

        System.out.println(solution(N,array));
    }

    public static int solution(int N, char[][] array){
        return dijkstra(N,array);
    }

    private static int dijkstra(int N, char[][] array) {
        int[][] visited = new int[N][N];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0,0));

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i],-1);
        }

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        while(!pq.isEmpty()){
            Point p = pq.poll();

            if(p.x == N-1 && p.y == N-1) break;

            for (int i = 0; i < 4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<N){
                    if(visited[nx][ny] == -1){
                        visited[nx][ny] = p.cnt;

                        if(array[nx][ny] == '0'){
                            pq.add(new Point(p.cnt+1,nx,ny));
                        }else{
                            pq.add(new Point(p.cnt,nx,ny));
                        }
                    }
                }
            }
        }

        return visited[N-1][N-1];
    }

}
