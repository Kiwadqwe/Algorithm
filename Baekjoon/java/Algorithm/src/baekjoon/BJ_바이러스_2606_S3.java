package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_바이러스_2606_S3 {
	static int V,E,cnt;
	static int[][] array;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		array = new int[V+1][V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			array[a][b] = 1;
			array[b][a] = 1;
		}
		
		visited = new boolean[V+1];
		dfs(1);
		
		System.out.println(cnt-1);
		
	}

	private static void dfs(int v) {
		visited[v] = true;
		cnt++;
		
		for (int i = 1; i < V+1; i++) {
			if(!visited[i] && array[v][i] == 1) {
				dfs(i);
			}
		}
	}

}