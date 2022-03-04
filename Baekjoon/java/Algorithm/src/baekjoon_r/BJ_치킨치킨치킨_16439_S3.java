package baekjoon_r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_치킨치킨치킨_16439_S3 {
    static int N,M,result;
    static int[][] array;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        visited = new boolean[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0,0);
        System.out.println(result);
    }

    private static void comb(int start, int d) {
        if(d == 3){
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int tp = 0;
                for (int j = 0; j < M; j++) {
                    if(visited[j]){
                        tp = Math.max(tp,array[i][j]);
                    }
                }
                sum+=tp;
            }

            result = Math.max(result,sum);
            return;
        }

        for (int i = start; i < M; i++) {
            if(!visited[i]){
                visited[i] = true;
                comb(i,d+1);
                visited[i] = false;
            }
        }
    }
}
