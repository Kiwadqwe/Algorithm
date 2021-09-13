package baekjoon;

import java.io.*;

public class BJ_1로만들기_1463_S3 {
	static int N;
	static int memo[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		dp();
		System.out.println(memo[N]);
	}

	private static void dp() {
		for(int i = 2; i < N+1; i++) {
			// 1을 빼는 경우
			memo[i] = memo[i-1]+1;
			
			if(i % 3 == 0) {
				memo[i] = Math.min(memo[i/3]+1, memo[i]);
			}
			if(i % 2 == 0) {
				memo[i] = Math.min(memo[i/2]+1, memo[i]);
			}
		}
	}
}