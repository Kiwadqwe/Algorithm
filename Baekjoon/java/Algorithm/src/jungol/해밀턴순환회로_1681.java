package jungol;

import java.io.*;
import java.util.*;

public class 해밀턴순환회로_1681 {
	static int N,result;
	static int[][] array;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		result = 1000001;
		dfs(0,0,0);
		System.out.println(result);
	}

	private static void dfs(int idx, int start, int tp) {
		// 시간 초과
		if(result <= tp) return;
		if(idx == N-1) {
			if(array[start][0] != 0) {
				result = Math.min(result, tp+array[start][0]);
			}
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if(visited[i]) continue;
			if(array[start][i] == 0) continue;

			visited[i] = true;
			dfs(idx+1,i,tp+array[start][i]);
			visited[i] = false;
		}
	}
}