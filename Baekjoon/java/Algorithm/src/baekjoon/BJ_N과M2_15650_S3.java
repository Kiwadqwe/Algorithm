package baekjoon;

import java.util.Scanner;

public class BJ_N과M2_15650_S3 {
	static int N,M;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		sb = new StringBuilder();
		
		comb(M,new int[M], 1);
		System.out.println(sb);
	}

	private static void comb(int idx, int[] choosed, int start) {
		if(idx == 0) {
			for (int i = 0; i < choosed.length; i++) {
				sb.append(choosed[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			choosed[choosed.length - idx] = i;
			comb(idx-1,choosed,i+1);
		}
	}
}