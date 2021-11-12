package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_나이트의이동_7562_S2 {
	static int L,cnt,a,b;
	static boolean[][] visited;
	static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	
	public static class Point {
		int x,y,cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(st.nextToken());
		for (int t = 0; t < TC; t++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			cnt = 0;
			visited = new boolean[L][L];
			if(x != a || y != b) {
				bfs(x,y);
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y,0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();

			if(p.x == a && p.y == b) {
				cnt = p.cnt;
				break;
			}
			
			for (int i = 0; i < 8; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<L && 0<=ny && ny<L) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new Point(nx,ny,p.cnt+1));
					}
				}
			}
		}
	}	
}