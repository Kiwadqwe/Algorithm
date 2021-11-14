package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_섬의개수_4963_S2 {
	static int W,H,cnt;
	static int[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	public static class Point {
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while(true) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			if(W == 0 && H == 0) break;
			
			array = new int[W][H];
			visited = new boolean[W][H];
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < H; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 0;
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < H; j++) {
					if(array[i][j] == 1 && !visited[i][j]) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(0<=nx && nx<W && 0<=ny && ny<H) {
				if(!visited[nx][ny] && array[nx][ny] == 1) {
					visited[nx][ny] = true;
					dfs(nx,ny);
				}
			}
		}
	}
}