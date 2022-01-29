package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_N과M6_15655_S3 {
    static int N,M;
    static int[] array;
    static StringBuilder sb = new StringBuilder();

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
        comb(0,0,new int[M]);
        System.out.println(sb);
    }

    private static void comb(int start, int idx, int[] choosed){
        if(idx == M){
            for (int i = 0; i < M; i++) {
                sb.append(choosed[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            choosed[idx] = array[i];
            comb(i+1,idx+1,choosed);
        }
    }
}
