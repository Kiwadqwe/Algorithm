package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_N과M3_15651_S3 {
	static int N,M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 sb = new StringBuilder();
		 
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 
		 // nCr의 r값을 넣음
		 comb(0,new int[M],0);
		 System.out.println(sb);
	}

	private static void comb(int idx, int[] choosed, int start) {
		if(idx == M) {
			// 배열의 크기만큼 출력
			for (int i = 0; i < M; i++) {
				sb.append(choosed[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			choosed[idx] = i;
			comb(idx+1 ,choosed ,i+1);
		}
	}
}