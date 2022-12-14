import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1로만들기_1463_S3 {
    static int X;

    public static class Point{
        int x,cnt;

        public Point(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());

        System.out.println(go());
    }

    public static int go(){
        Queue<Point> q = new LinkedList();
        q.add(new Point(X,0));

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == 1) return p.cnt;

            if(p.x % 3 == 0){
                q.add(new Point(p.x/3,p.cnt+1));
            }

            if(p.x % 2 == 0){
                q.add(new Point(p.x/2,p.cnt+1));
            }

            q.add(new Point(p.x-1,p.cnt+1));
        }
        return X;
    }
}
