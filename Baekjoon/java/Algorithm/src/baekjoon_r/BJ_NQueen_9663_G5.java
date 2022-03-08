package baekjoon_r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_NQueen_9663_G5 {
    static int N,cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());


        cal(0,new boolean[N][N], new int[N]);
        System.out.println(cnt);
    }

    private static boolean check(int i, int j, int x, int y){
        if(Math.abs(i-x) == Math.abs(j-x)) return false;
        if(j == y) return false;
        return true;
    }

    private static void cal(int idx,boolean[][] visited, int[] choosed){
        if(idx == N){
            cnt++;
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && check(i,j,idx,choosed[j])){
                    visited[i][j] = true;
                    cal(idx+1, visited,choosed);
                    visited[i][j] = false;
                }
            }
        }
    }
}
