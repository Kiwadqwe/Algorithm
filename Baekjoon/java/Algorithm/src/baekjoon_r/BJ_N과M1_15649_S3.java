package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_N과M1_15649_S3 {
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        permu(0, new boolean[N] ,new int[M]);
        System.out.println(sb);
    }

    private static void permu(int idx, boolean[] visited, int[] choosed){
        if(idx == M){
            for (int i = 0; i < choosed.length; i++) {
                sb.append(choosed[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                choosed[idx] = i+1;
                permu(idx+1,visited,choosed);
                visited[i] = false;
            }
        }
    }
}