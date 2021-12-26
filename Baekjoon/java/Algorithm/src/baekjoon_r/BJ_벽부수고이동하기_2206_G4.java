package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_벽부수고이동하기_2206_G4 {
	static int N,M;
	static int[][] array;
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Point {
		int x,y,cnt,check;
		
		public Point(int x, int y, int cnt, int check) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.check = check;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		visited = new boolean[N][M][2];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				array[i][j] = s.charAt(j) -'0';
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,1,0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == N-1 && p.y == M-1) {
				return p.cnt;
			}
			
			for(int i=0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || N<=nx || ny<0 || M<=ny) continue;
				if(!visited[nx][ny][p.check]) {
					if(array[nx][ny] == 0) {
						visited[nx][ny][p.check] = true;
						q.add(new Point(nx,ny,p.cnt+1,p.check));
					} else if(array[nx][ny] == 1 && p.check == 0) {
						visited[nx][ny][1] = true;
						q.add(new Point(nx,ny,p.cnt+1,1));
					}
				}
			}
		}
		return -1;
	}
}