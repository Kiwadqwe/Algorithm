package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_적록색약_10026_G5 {
	static int N;
	static char[][] array;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static StringBuilder sb;
	static boolean[][] visited;
	
	public static class Point {
		int x,y;
		
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		array = new char[N][];
		for (int i = 0; i < N; i++) {
			array[i] = br.readLine().toCharArray();
		}
		
		bgb();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(array[i][j] == 'G') {
					array[i][j] = 'R';
				}
			}
		}
		
		bgb();
		
		System.out.println(sb);
	}

	private static void bgb() {
		int cnt = 0;
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					if(array[i][j] == 'R' || array[i][j] == 'B' || array[i][j] == 'G') {
						bfs(i,j,array[i][j]);
						cnt+=1;
					}
				}
			}
		}
		sb.append(cnt).append(" ");
	}

	private static void bfs(int x,int y, char c) {
		Queue<Point> q = new LinkedList<Point>();
		visited[x][y] = true;
		q.add(new Point(x,y));
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				Point p = q.poll();
				x = p.x;
				y = p.y;
				
				for (int i = 0; i < 4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(0<=nx && nx<N && 0<=ny && ny<N) {
						if(!visited[nx][ny]) {
							if(array[nx][ny] == c) {
								visited[nx][ny] = true;
								q.add(new Point(nx,ny));
							}
						}
					}
				}
			}
		}
	}
}