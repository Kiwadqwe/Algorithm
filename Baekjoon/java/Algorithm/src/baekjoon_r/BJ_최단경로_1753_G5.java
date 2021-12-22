package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_최단경로_1753_G5 {
	static int V,E,K,cnt;
	static PriorityQueue<Point> pq;
	static ArrayList<ArrayList<Point>> list;
	static int[] d;
	static final int INF = (int) 1e9;
	
	public static class Point implements Comparable<Point> {
		int x,dis;
		
		public Point(int x, int dis) {
			this.x = x;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.dis - o.dis;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for (int i = 0; i < V+1; i++) {
			list.add(new ArrayList<Point>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Point(v,w));
		}
		
		d = new int[V+1];
		for (int i = 0; i < V+1; i++) {
			Arrays.fill(d, INF);
		}
		
		dijkstra();
		
		for (int i = 1; i < V+1; i++) {
			if(d[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(d[i]);
			}
		}
	}

	private static void dijkstra() {
		pq = new PriorityQueue<>();
		pq.add(new Point(K,0));
		d[K] = 0;
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			for (Point e: list.get(p.x)) {
				// 현재 경로의 돈이 다른 경로의 돈보다 작은 경우
				if(d[p.x] + e.dis < d[e.x]) {
					d[e.x] = d[p.x] + e.dis;
					pq.add(new Point(e.x,d[e.x]));
				}
			}
		}
		
	}
	
}