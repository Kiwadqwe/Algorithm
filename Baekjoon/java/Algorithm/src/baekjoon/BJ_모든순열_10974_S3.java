package baekjoon;

import java.util.*;

public class BJ_모든순열_10974_S3 {
	static int N;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sb = new StringBuilder();
		
		permu(N,new int[N], new boolean[N+1]);
		
		System.out.println(sb);
	}

	private static void permu(int idx, int[] choosed, boolean[] visited) {
		if(idx == 0) {
			for (int i = 0; i < choosed.length; i++) {
				sb.append(choosed[i]).append(" ");
			}
			sb.append("\n");
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[choosed.length - idx] = i;
				permu(idx-1, choosed, visited);
				visited[i] = false;
			}
		}
	}
}