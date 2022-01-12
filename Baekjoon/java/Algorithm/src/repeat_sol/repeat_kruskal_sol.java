package repeat_sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import repeat.repeat_kruskal.Point;

public class repeat_kruskal_sol {
	static int T,V,E,hap,edgeCnt;
	static PriorityQueue<Point> pq;
	static int[] repres;
	
	public static class Point implements Comparable<Point>{
		int from, to, dis;
		
		public Point(int from, int to, int dis) {
			this.from = from;
			this.to = to;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.dis, o.dis);
		}
	}
	
	// 크루스칼 : 최소비용으로 모든 정점을 연결하자
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>(); 
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			pq.add(new Point(A,B,C));
		}
		
		make();
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(find(p.from) != find(p.to)){
				union(p.from, p.to);
				hap += p.dis;
			}
		}
		
		System.out.println(hap);
	}

	private static void union(int from, int to) {
		int a = find(from);
		repres[a] = find(to);
	}

	private static int find(int a) {
		if(repres[a] != a) {
			repres[a] = find(repres[a]);
		}
		return repres[a];
	}

	private static void make() {
		repres = new int[V+1];
		for(int i=0; i<V+1; i++) {
			repres[i] = i;
		}
	}
}
//3 3
//1 2 1
//2 3 2
//1 3 3

//3