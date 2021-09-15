package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_치즈_2636_G5 {
	static int N,M,cnt;
	static int[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static class Point{
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
		
		array = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		// 이 맵 전체 사이즈 안에는 끝날거니깐
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(array[i][j] == 1) {
					bfs(new Point(0,0));
					// 시간 카운트
					time += 1;
				}
			}
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(point);
		array[0][0] = 0;
		visited = new boolean[N][M];
		visited[point.x][point.y] = true;
		cnt = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(!visited[nx][ny]) {
						// 0을 돌면서 상하좌우가 치즈일 경우에는 0으로 만들어버림
						if(array[nx][ny] == 1) {
							array[nx][ny] = 0;
							// 남아 있는 치즈 카운트
							cnt += 1;
							
						// 0일 경우에 돔
						}else {
							q.add(new Point(nx,ny));
						}
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
}