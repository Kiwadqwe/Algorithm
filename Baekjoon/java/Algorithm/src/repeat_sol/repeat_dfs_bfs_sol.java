package repeat_sol;

import java.io.*;
import java.util.*;

public class repeat_dfs_bfs_sol {
	static int N,M,V;
	static int[][] array;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			array[a][b] = 1;
			array[b][a] = 1;
		}
		
		visited = new boolean[N+1]; 
		dfs(V);
		System.out.println();
		visited = new boolean[N+1]; 
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int V = q.poll();
			System.out.print(V+" ");
			for (int i = 0; i < N+1; i++) {
				if(!visited[i] && array[V][i] == 1) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

	private static void dfs(int V) {
		visited[V] = true;
		System.out.print(V+" ");
		for (int i = 0; i < N+1; i++) {
			if(!visited[i] && array[V][i] != 0) {
				dfs(i);
			}
		}
	}

}

//4 5 1
//1 2
//1 3
//1 4
//2 4
//3 4

//1 2 4 3
//1 2 3 4
