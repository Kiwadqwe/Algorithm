package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_토마토_7576_S1 {
	static int N,M,cnt,result;
	static int[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean check;
	
	public static class Point {
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(array[i][j] == 0) {
					check = true;
				}
				result = Math.max(result, array[i][j]);
			}
		}
		if(check) System.out.println("-1");
		else System.out.println(result-1);
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(array[i][j] == 1) {
					q.add(new Point(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<M && 0<=ny && ny<N) {
					if(array[nx][ny] == 0) {
						array[nx][ny] = array[p.x][p.y]+1;
						q.add(new Point(nx,ny));
					}
				}
			}
		}
	}
}