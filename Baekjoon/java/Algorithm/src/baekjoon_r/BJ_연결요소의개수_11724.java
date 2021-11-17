package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_연결요소의개수_11724 {
	static int N,M,cnt;
	static int[][] array;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());	
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			array[u][v] = 1;
			array[v][u] = 1;
		}
		
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		
		System.out.println(cnt);
	}

	private static void dfs(int v) {
		visited[v] = true;
		
		for (int i = 1; i < N+1; i++) {
			if(!visited[i] && array[v][i] == 1) {
				dfs(i);
			}
		}
	}

}