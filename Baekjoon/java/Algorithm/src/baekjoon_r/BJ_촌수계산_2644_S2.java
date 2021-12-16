package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_촌수계산_2644_S2 {
	static int N,M,X,Y,cnt,result;
	static int[][] array;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		array = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			array[a][b] = 1;
			array[b][a] = 1;
		}
		
		visited = new boolean[N+1];
		result = -1;
		dfs(X,cnt);
		System.out.println(result);
	}

	private static void dfs(int x, int cnt) {
		if(x == Y) {
			result = cnt;
			return;
		}
		
		for (int i = 1; i < N+1; i++) {
			if(!visited[i] && array[x][i] == 1) {
				visited[x] = true;
				dfs(i, cnt+1);
			}
		}
	}

}