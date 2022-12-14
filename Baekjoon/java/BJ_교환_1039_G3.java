import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_교환_1039_G3 {
    static int num;

    public static class Point {
        int cnt,x;

        public Point(int cnt, int x){
            this.cnt = cnt;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(solution(N,M));
    }

    public static int solution(int N, int M){
        return bfs(N,M);
    }

    private static int bfs(int n, int m) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,n));

        int N = Integer.toString(n).length();
        int[] array = new int[N];
        int result = -1;
        boolean[][] visited = new boolean[m+1][1000001];

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.cnt == m){
                result = Math.max(result,p.x);
                continue;
            }

            for (int i = 0; i < N; i++) {
                array[i] = Integer.toString(p.x).charAt(i) - '0';
            }

            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    swap(array,i,j);
                    num = 0;

                    for(int a : array){
                        num *= 10;
                        num += a;
                    }

                    if(N != Integer.toString(num).length()){
                        swap(array,i,j);
                        continue;
                    }

                    if(!visited[p.cnt][num]){
                        q.add(new Point(p.cnt+1,num));
                        visited[p.cnt][num] = true;
                    }

                    swap(array,i,j);
                }
            }
        }

        return result;
    }

    public static void swap(int[] array,int i, int j){
        int t = 0;

        t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
