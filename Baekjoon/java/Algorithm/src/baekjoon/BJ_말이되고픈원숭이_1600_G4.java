package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_말이되고픈원숭이_1600_G4 {
	static int K,W,H,cnt;
	static int[][] array;
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	// 총 8가지
	static int[] night_dx = {-1,1,2,2,1,-1,-2,-2};
	static int[] night_dy = {-2,-2,-1,1,2,2,1,-1};
			
	public static class Point {
		int x,y,cnt,K;
		
		public Point(int x,int y, int cnt,int K) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.K = K;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// Row, Col, 말 or 원숭이
		visited = new boolean[H][W][K+1];
		
		array = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs(new Point(0,0,cnt,K)));
	}

	private static int bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		visited[point.x][point.y][K] = true;
		q.add(point);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			cnt = p.cnt;
			K = p.K;
			
			if(p.x == H-1 && p.y == W-1) {
				return cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<H && 0<=ny && ny<W) {
					if(array[nx][ny] != 1) {
						if(!visited[nx][ny][K]) {
							visited[nx][ny][K] = true;
							q.add(new Point(nx,ny,cnt+1,K));
						}
					}
				}
			}
			
			if(0 < K) {
				for (int i = 0; i < 8; i++) {
					int nx = p.x+night_dx[i];
					int ny = p.y+night_dy[i];
					
					if(0<=nx && nx<H && 0<=ny && ny<W) {
						if(array[nx][ny] != 1) {
							if(!visited[nx][ny][K-1]) {
								visited[nx][ny][K-1] = true;
								q.add(new Point(nx,ny,cnt+1,K-1));
							}
						}
					}
				}
			}
		}
		return -1;
	}
}