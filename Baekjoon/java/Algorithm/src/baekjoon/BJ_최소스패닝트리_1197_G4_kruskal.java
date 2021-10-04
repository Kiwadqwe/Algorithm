package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_최소스패닝트리_1197_G4_kruskal {
	static int T,V,E,hap,edgeCnt;
	static PriorityQueue<Point> pq;
	static int[] repres;
	
	public static class Point implements Comparable<Point> {
		int from, to, dis;
		
		public Point(int from, int to, int dis) {
			this.from = from;
			this.to = to;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.dis, o.dis);
		}
	}
	
	public static void main(String[] args) throws Exception {
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

		while(!pq.isEmpty()){
			Point p = pq.poll();
			union(p.from, p.to, p.dis);
			if(edgeCnt == V-1) {
				break;
			}
		}
		
		System.out.println(hap);
	}

	private static void union(int a, int b, int dis) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			repres[a] = b;
			hap += dis;
			edgeCnt+=1;
		}
	}

	private static int find(int a) {
		if(repres[a] == a) {
			return a;
		}else {
			return repres[a] = find(repres[a]);
		}
	}

	private static void make() {
		repres = new int[V+1];
		for (int i = 0; i < repres.length; i++) {
			repres[i] = i;
		}
	}
}