package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_N과M5_15654_S3 {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        permu(0,0,new boolean[N],new int[M]);
        System.out.println(sb);
    }

    private static void permu(int start, int idx, boolean[] visited, int[] choosed){
        if(idx == M){
            for (int i = 0; i < M; i++) {
                sb.append(choosed[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                choosed[idx] = array[i];
                visited[i] = true;
                permu(i+1,idx+1,visited,choosed);
                visited[i] = false;
            }

        }
    }
}