package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_벽부수고이동하기2_14442_G3 {
	static int N,M,K;
	static char[][] array;
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Point {
		int x,y,cnt,k;
		
		public Point(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new char[N][M];
		visited = new boolean[N][M][K+1];
		
		for (int i = 0; i < N; i++) {
			array[i] = br.readLine().toCharArray();
		}
		
		int result = bfs(new Point(0,0,1,K));
		System.out.println(result);
	}

	private static int bfs(Point point) {
		Queue<Point> q = new LinkedList<>();
		visited[point.x][point.y][point.k] = true;
		q.add(point);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			System.out.println(p.x+" "+p.y+" "+p.cnt+" "+p.k);
			
			if(p.x == N-1 && p.y == M-1) {
				return p.cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(!visited[nx][ny][p.k]) {
						
					}
				}
			}
		}
		
		return -1;
	}
}