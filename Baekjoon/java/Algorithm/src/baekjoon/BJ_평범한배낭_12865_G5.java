package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_평범한배낭_12865_G5 {
	static int N,K,W,V;
	static int[] weights, profits;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		weights = new int[N+1];
		profits = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}

		int[][] d = new int[N+1][K+1];
		
		// 물건의 개수 만큼
		for (int i = 1; i <= N; i++) {
			// 1~K 무게 까지
			for (int w = 1; w <= K; w++) {
				// 배낭에 넣을 수 있을 때
				// 현재 가방의 무게가 넣을려는 무게보다 클 때
				if(weights[i] <= w) {
					// 물건을 담지 않았을 때, 물건을 담았을 경우(이전 물건까지의 최적의 가치 + 현재 물건의 가치)
					d[i][w] = Math.max(d[i-1][w], profits[i] + d[i-1][w-weights[i]]);
				// 배낭에 넣지 못할 때
				}else {
					// 전 상황의 물건의 가치를 넣어줌
					d[i][w] = d[i-1][w];
				}
			}
		}
		
		System.out.println(d[N][K]);
	}
}