package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_N과M3_15651_S3 {
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        comb(0,new int[M]);
        System.out.println(sb);
    }

    private static void comb(int idx, int[] choosed){
        if(idx == M){
            for (int i = 0; i < M; i++) {
                sb.append(choosed[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            choosed[idx] = i+1;
            comb(idx+1,choosed);
        }
    }
}