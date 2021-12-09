package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_배열돌리기1_16926_S3 {
	static int N,M,R,dir;
	static int[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static List<Integer> arr;
	static int[][] result;
	static List<Integer> temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = new int[N][M];
		int a = Math.min(N, M);
		visited = new boolean[N][M];
		arr = new ArrayList<>();
		dfs(0,0,0);
		int b = N;
		int c = M;
		visited = new boolean[N][M];
		for (int k = 0; k < a/2; k++) {
			int tp = (b*c)-(b-2)*(c-2);
			b -= 2;
			c -= 2;
			temp = new ArrayList<>();
			for (int z = 0; z < tp; z++) {
				temp.add(arr.remove(0));
			}
			
			for (int i = 0; i < R; i++) {
				Collections.rotate(temp, -1);
			}
			dfs2(k,k,0);
		}
		print();
	}
			
	private static void dfs(int x, int y, int dir) {
		visited[x][y] = true;
		arr.add(array[x][y]);
		for (int i = dir; i < dir+4; i++) {
			int nx = dx[i%4]+x;
			int ny = dy[i%4]+y;
			
			if (0<=nx && nx<N && 0<=ny && ny<M) {
				if (!visited[nx][ny]) {
					dfs(nx,ny,i);
					}
				}
			}
		}
	
	private static void dfs2(int x, int y, int dir) {
		result[x][y] = temp.remove(0);
		for (int i = dir; i < dir+4; i++) {
			int nx = dx[i%4]+x;
			int ny = dy[i%4]+y;
			
			if (0<=nx && nx<N && 0<=ny && ny<M) {
				if(!temp.isEmpty()) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						dfs2(nx,ny,i);
						}
					}
				}
			}
		}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}