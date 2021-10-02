package swexpertacademy;

import java.io.*;
import java.util.*;

public class 탈주범검거_1953 {
	static int TC,N,M,R,C,L,cnt;
	static int[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy  = {0,1,0,-1};
	
	public static class Point {
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			array = new int[N][M];
			visited = new boolean[N][M];
			cnt = 1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < M; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(new Point(R,C));
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean check(int a, int b,int d) {
		
		if(d == 0) {
			if(a == 1 || a == 2 || a == 4 || a == 7) {
				if(b == 1 || b == 2 || b == 5 || b == 6) {
					return true;
				}
			}
		}else if(d == 1) {
			if(a == 1 || a == 3 || a == 4 || a == 5) {
				if(b == 1 || b == 3 || b == 6 || b == 7) {
					return true;
				}
			}
		}else if(d == 2) {
			if(a == 1 || a == 2 || a == 5 || a == 6) {
				if(b == 1 || b == 2 || b == 4 || b ==7) {
					return true;
				}
			}
		}else if(d == 3) {
			if(a == 1 || a == 3 || a == 6 || a == 7) {
				if(b == 1 || b == 3 || b == 4 || b == 5) {
					return true;
				}
			}
		}
		return false;
	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(point.x,point.y));
		visited[point.x][point.y] = true;
		
		int time = 1, size = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(size --> 0) {
				Point p = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					
					if(time == L) return;
					
					if(0<=nx && nx<N && 0<=ny && ny<M) {
						if(!visited[nx][ny] && array[nx][ny] != 0) {
							if(check(array[p.x][p.y],array[nx][ny],i)) {
								cnt +=1;
								visited[nx][ny] = true;
								q.add(new Point(nx,ny));
							}
						}
					}
				}
			}
			time+=1;
		}
	}
}