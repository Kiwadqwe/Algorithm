package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_유기농배추_1012_S2 {
	static int N,M,K,cnt;
	static int[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int TC = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			array = new int[N][M];			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				array[a][b] = 1;
			}
			
			cnt = 0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
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
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || N<=nx || ny<0 || M<=ny) continue;
			
			if(array[nx][ny] == 1 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx,ny);
			}
		}
		
	}

}