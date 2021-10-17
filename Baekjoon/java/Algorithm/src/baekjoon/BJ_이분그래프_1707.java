package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_이분그래프_1707 {
	static int K,V,E;
	static Point[] array;
	static int[] visited;
	static String result;
	
	public static class Point { 
		int n;
		Point pre;
		
		public Point(int n, Point pre) {
			this.n = n;
			this.pre = pre;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		K = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine());	
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			array = new Point[V+1];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				array[a] = new Point(b,array[a]);
				array[b] = new Point(a,array[b]);
			}

			result = "YES";
			visited = new int[V+1];
			for (int i = 1; i <= V; i++) {
				if(visited[i] ==  0 
						&& result.equals("YES")) {
					dfs(i,1);
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int i, int group) {
		visited[i] = group;
		Point p = array[i];

		while(p != null) {
			if(visited[p.n] == 0) {
				dfs(p.n, group * -1);
			}else {
				if(visited[i] == visited[p.n]) {
					result = "NO";
					return;
				}
			}
			
			p = p.pre;
		}
	}
}