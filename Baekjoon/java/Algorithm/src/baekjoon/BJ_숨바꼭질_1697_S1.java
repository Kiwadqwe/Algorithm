package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_숨바꼭질_1697_S1 {
	static int N,K,cnt;
	static boolean[] visited;
	
	public static class Point {
		int x,cnt;
		
		public Point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
		
		bfs(new Point(N,0));
		System.out.println(cnt);
	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(point);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			cnt = p.cnt;
			
			if(p.x == K) {
				return;
			}
			
			if(!visited[p.x]) {
				visited[p.x] = true;
				// x-1 
				if(0 <= p.x-1) q.add(new Point(p.x-1,cnt+1));
				// x+2
				if(p.x+1 <= 100000) q.add(new Point(p.x+1,cnt+1));
				//x*2
				if(p.x*2 <= 100000) q.add(new Point(p.x*2,cnt+1));
			}
		}
	}
}