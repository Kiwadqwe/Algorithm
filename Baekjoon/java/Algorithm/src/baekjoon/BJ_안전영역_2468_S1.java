package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_안전영역_2468_S1 {
	static int N,max,cnt;
	static int[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Point {
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, array[i][j]);
			}
		}
		
		int result = 0;
				
		for (int k = 0; k <= max; k++) {
			visited = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && array[i][j] > k) {
						cnt += 1;
						bfs(i,j,k);
			result = Math.max(result, cnt);
					}
				}
			}
		}
		System.out.println(result);
	}

	private static void bfs(int x, int y, int k) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			x = p.x;
			y = p.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					if(!visited[nx][ny]) {
						if(array[nx][ny] > k) {
							visited[nx][ny] = true;
							q.add(new Point(nx,ny));
						}
					}
				}
			}
		}
	}
}