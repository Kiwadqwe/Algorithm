package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_키순서_2458_G4_Floyd {
	static int N,M,cnt;
	static int[][] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][N+1];
		int INF = 1000001;
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				array[i][j] = INF;
			}
		}
		
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			array[from][to] = 1;
		}

		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				if(i == k) continue;
				for (int j = 1; j < N+1; j++) {
					if(i == j || j == k) continue;
					array[i][j] = Math.min(array[i][k]+array[k][j], array[i][j]);
				}
			}
		}
		
		int result = 0;
		for (int i = 1; i < N+1; i++) {
			int cnt = 0;
			for (int j = 1; j < N+1; j++) {
				if(array[i][j] != INF || array[j][i] != INF) {
					cnt+=1;
				}
			}
			if(cnt == N-1) ++result;
		}
		
		System.out.println(result);
	}
}