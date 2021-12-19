package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_음식물피하기_1743_S1 {
	static int N,M,K,cnt,result;
	static int[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			array[a][b] = 1;
				
		}
		
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && array[i][j] == 1) {
					cnt = 0;
					dfs(i,j);	
					result = Math.max(result, cnt);
				}
			}
		}
		
		System.out.println(result);
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<M) {
				if(!visited[nx][ny] && array[nx][ny] == 1) {
					visited[nx][ny] = true;
					cnt++;
					dfs(nx,ny);
				}
			}
		}
	}

}