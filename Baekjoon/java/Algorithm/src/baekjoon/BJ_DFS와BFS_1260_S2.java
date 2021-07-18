package baekjoon;

import java.util.*;
import java.io.*;

public class BJ_DFS와BFS_1260_S2 {
	static int n,m,v;
	static boolean visited[];
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		map = new int[n+1][n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		bfs();
	}

	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		for (int i= 0; i < n+1; i++) {
			if(!visited[i] && map[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.remove();
			System.out.print(v +" ");
			for (int i = 0; i <n+1; i++) {
				if(!visited[i] && map[v][i] == 1) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

//	private static void print() {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map.length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}
}