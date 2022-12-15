import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_미로만들기_2665_G4_bfs {

    public static class Point {
        int cnt;
        int x,y;

        public Point(int cnt, int x, int y){
            this.cnt = cnt;
            this.x = x;
            this.y = y;
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
        return bfs(N,array);
    }

    private static int bfs(int N, char[][] array) {
        Queue<Point> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][N][N*N];
        q.add(new Point(0,0,0));
        visited[0][0][0] = true;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int result = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(result <= p.cnt) continue;

            if(p.x == N-1 && p.y == N-1){
                result = Math.min(result,p.cnt);
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<N){
                    if(array[nx][ny] == '0'){
                        if(!visited[nx][ny][p.cnt+1]){
                            q.add(new Point(p.cnt+1,nx,ny));
                            visited[nx][ny][p.cnt+1] = true;
                        }
                    }else{
                        if(!visited[nx][ny][p.cnt]) {
                            q.add(new Point(p.cnt,nx,ny));
                            visited[nx][ny][p.cnt] = true;
                        }
                    }
                }
            }
        }
        return result;
    }
}
