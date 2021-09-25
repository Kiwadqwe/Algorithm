package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_나이트의이동_7562_S2 {
	static int L,area_x,area_y,cnt;
	static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	static boolean[][] visited;
	
	public static class Point {
		int x,y,cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			L = Integer.parseInt(br.readLine());
			visited = new boolean[L][L];
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			area_x = Integer.parseInt(st.nextToken());
			area_y = Integer.parseInt(st.nextToken());
			
			bfs(a,b);
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		visited[x][y] = true;
		q.add(new Point(x,y,cnt));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			cnt = p.cnt;
			
			if(p.x == area_x && p.y == area_y) return;
			
			for (int i = 0; i < 8; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(0<=nx && nx<L && 0<=ny && ny<L) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new Point(nx,ny,cnt+1));
					}
				}
			}
		}
	}
}