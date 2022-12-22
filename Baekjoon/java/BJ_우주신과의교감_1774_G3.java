import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_우주신과의교감_1774_G3 {
    static int[] p;
    static Queue<Point> pq = new PriorityQueue<>();

    public static class Point implements Comparable<Point>{
        double d;
        int x,y;

        public Point(double d, int x, int y){
            this.d = d;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            return this.d < point.d ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] coordinate = new int[N+1][2];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coordinate[i][0] = x;
            coordinate[i][1] = y;
        }

        p = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            p[i] = i;
        }

        for (int i = 1; i < N; i++) {
            int x = coordinate[i][0];
            int y = coordinate[i][1];
            for (int j = i+1; j < N+1; j++) {
                int x2 = coordinate[j][0];
                int y2 = coordinate[j][1];
                double d = Math.sqrt(Math.pow(Math.abs(x-x2),2)+Math.pow(Math.abs(y-y2),2));
                pq.add(new Point(d,i,j));
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(find(x) != find(y)){
                union(x,y);
                N-=1;
            }
        }

        double answer = 0;

        while(!pq.isEmpty() && N-1 != 0){
            Point p = pq.poll();

            if(find(p.x) != find(p.y)){
                union(p.x,p.y);
                answer+=p.d;
                N-=1;
            }
        }

        System.out.printf("%.2f\n",answer);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y){
            p[y] = x;
        }else{
            p[x] = y;
        }
    }

    private static int find(int x){
        if(x != p[x]){
            p[x] = find(p[x]);
        }

        return p[x];
    }
}
