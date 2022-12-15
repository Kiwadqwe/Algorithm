import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_돌그룹_12886_G4 {
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static int A,B,C;

    public static class Point {
        int x,y,z;

        public Point(int x, int y,int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list.add(A);
        list.add(B);
        list.add(C);
        Collections.sort(list);

        System.out.println(solution(list.get(0),list.get(1),list.get(2)));
    }

    public static int solution(int A, int B, int C){
        return bfs(A,B,C);
    }

    private static int bfs(int a, int b, int c) {
        q.add(new Point(a,b,c));

        visited = new boolean[a+b+c][a+b+c];
        visited[a][b] = true;
        int hap = a+b+c;
        int[] array;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == p.y && p.y == p.z){
                return 1;
            }

            array = new int[]{p.x,p.y,p.z};

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == j) continue;
                    C = hap-(array[i]+array[j]);

                    if(array[i] < array[j]) {
                        A = array[i] * 2;
                        B = array[j]-array[i];

                        if (!visited[A][B]){
                            visited[A][B] = true;
                            q.add(new Point(A,B, C));
                        }
                    }

                    if(array[j] < array[i]){
                        A = array[j] * 2;
                        B = array[i] - array[j];

                        if (!visited[A][B]){
                            visited[A][B] = true;
                            q.add(new Point(A,B, C));
                        }
                    }
                }
            }
        }

        return 0;
    }
}
