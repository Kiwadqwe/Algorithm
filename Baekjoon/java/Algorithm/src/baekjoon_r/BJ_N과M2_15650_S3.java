package baekjoon_r;
import java.io.*;
import java.util.*;

public class BJ_N과M2_15650_S3 {
    static int N,M;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        comb(0,0,new int[M]);

        System.out.println(sb);
    }

    private static void comb(int start, int idx, int[] choosed){
        if(idx == M){
            for (int i = 0; i < choosed.length; i++) {
                sb.append(choosed[i]+" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            choosed[idx] = i+1;
            comb(i+1,idx+1,choosed);
        }
    }
}