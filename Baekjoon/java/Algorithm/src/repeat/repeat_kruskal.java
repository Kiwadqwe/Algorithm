package repeat;

import java.io.*;
import java.util.*;

public class repeat_kruskal {
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
		
		
		System.out.println(hap);
	}

	private static void union(int from, int to) {


}

//3 3
//1 2 1
//2 3 2
//1 3 3

//3