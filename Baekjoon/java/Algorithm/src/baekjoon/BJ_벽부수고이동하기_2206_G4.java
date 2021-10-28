package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_벽부수고이동하기_2206_G4 {
	static int N,M;
	static char[][] array;
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Point {
		int x,y,cnt,check;
		
		public Point(int x,int y, int cnt, int check) {
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
		
		array = new char[N][M];
		// 벽을 부슨 상태로 좌표에 도착했는지
		// 벽을 부슨 기회를 아직 사용하지 않고 좌표에 도착했는지 체크해주기위해서
		// 3차원 배열을 사용
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			array[i] = br.readLine().toCharArray();
		}
		// x,y 좌표 , cnt 거리 저장 , check 현재 벽을 부슨 기회를 사용했는지 안했는지 체크할거
		int result = bfs(new Point(0,0,1,0));
		System.out.println(result);
	}

	private static int bfs(Point point) {
		Queue<Point> q = new LinkedList<>();
		visited[point.x][point.y][point.check] = true;
		q.add(point);
		
		while(!q.isEmpty()) {
			Point p = q.poll();

			if(p.x == N-1 && p.y == M-1) {
				return p.cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(!visited[nx][ny][p.check]) {
						// 벽을 부슬 기회가 있을때 0
						if(p.check == 0) {
							if(array[nx][ny] == '1') {
								q.add(new Point(nx,ny,p.cnt+1,1));
							}else {
								q.add(new Point(nx,ny,p.cnt+1,0));
							}
						// 벽돌 부슬 기회가 없을때 1	
						}else {
							if(array[nx][ny] == '0') {
								q.add(new Point(nx,ny,p.cnt+1,1));
							}
						}
						
						visited[nx][ny][p.check] = true;
					}
				}
			}
		}
	return -1;
	
	}
}