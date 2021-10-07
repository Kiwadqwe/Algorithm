package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_최소스패닝트리_1197_G4_prim {
	static int V,E,hap;
	static Point[] array;
	
	public static class Point implements Comparable<Point> {
		int i,cost;
		Point pre;
		
		public Point(int i, int cost) {
			super();
			this.i = i;
			this.cost = cost;
		}
		
		public Point(int i, int cost, Point pre) {
			super();
			this.i = i;
			this.cost = cost;
			this.pre = pre;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cost, o.cost);
		}

	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		array = new Point[V+1]; 
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			array[A-1] = new Point(B-1,C,array[A-1]);
			array[B-1] = new Point(A-1,C,array[B-1]);
		}
		
		prim();
		
		System.out.println(hap);
	}

	private static void prim() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		// 임의의 한점에서 출발
		pq.add(new Point(0,0));
		
		int visitCnt = 1;
		
		while(!pq.isEmpty()) {
			// 맨앞에 가져오기
			Point p = pq.poll();
			
			// 방문 여부에 대한 처리 및 사용
			if(visited[p.i]) continue;
			
			visited[p.i] = true;
			hap += p.cost;
			
			// 모든 연결이 끝났다면 끝
			if(++visitCnt == V+1) return;
			
			// 가능한 자식 탐색
			Point pre = array[p.i];
			while(pre != null) {
				if(!visited[pre.i]) {
					pq.add(new Point(pre.i,pre.cost));
					// 여기서 담았지만 방문 처리는 사용할때 해준다.
				}
				pre = pre.pre;
			}
		}
	}
}