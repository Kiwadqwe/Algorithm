package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_최단경로_1753_G5 {
	static int V,E,K;
	static Point[] matrix;
	static int[] minEdge;
	static boolean[] visited;
	
	public static class Point implements Comparable<Point>{
		int n,weight,totalCost;
		Point p;
		
		public Point(int n, int weight, Point p) {
			this.n = n;
			this.weight = weight;
			this.p = p;
		}
		
		public Point(int n, int totalCost) {
			this.n = n;
			this.totalCost = totalCost;
		}

		@Override
		public String toString() {
			return "Point [n=" + n + ", weight=" + weight + ", totalCost=" + totalCost + ", p=" + p + "]";
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.totalCost, o.totalCost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		K = Integer.parseInt(st.nextToken());
		
		matrix = new Point[V+1];
		minEdge = new int[V+1];
		visited = new boolean[V+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			matrix[u] = new Point(v, w, matrix[u]);
		}
		dijkstra();
		
		for (int i = 1; i <= V; i++) {
			if(minEdge[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			}else {
				sb.append(minEdge[i]).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[K] = 0;
		
		pq.offer(new Point(K,0));

		while(!pq.isEmpty()) {
			Point p = pq.poll();
			// 혹시 방문했던 지점인지
			if(visited[p.n]) {
				continue;
			}
			// 그 점 방문해보기
			visited[p.n] = true;
			
			//  방문 가능한 지점들 가보기
			Point next = matrix[p.n];
		
		while(next != null) {
				if(!visited[next.n] &&  minEdge[next.n] > minEdge[p.n] + next.weight) {
					minEdge[next.n] = minEdge[p.n] + next.weight;
					pq.offer(new Point(next.n, minEdge[next.n]));
					}
				next = next.p;
			}
		}
	}
}