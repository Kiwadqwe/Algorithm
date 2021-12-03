package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_달이차오른다가자_1194_G1 {
	static int N,M,ms_x,ms_y;
	static char[][] array;
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Point {
		int x,y,key;
		
		public Point(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new char[N][M];
		// 키는 2^6으로 관리
		visited = new boolean[N][M][1<<6];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				array[i][j] = s.charAt(j);
				
				// 민식이의 위치 저장
				if(array[i][j] == '0') {
					ms_x = i;
					ms_y = j;
				}
			}
		}
		
		bfs(new Point(ms_x,ms_y,0));
	}
	
	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		// 현재 키는 임의의 값 넣어버림
		q.add(point);
		visited[point.x][point.y][point.key] = true;
		
		int depth = 0, size = 0;
		while(!q.isEmpty()) {
			size = q.size();
			while(size --> 0) {
				Point p = q.poll();
				
				if(array[p.x][p.y] == '1') {
					System.out.println(depth);
					return;
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					
					if(0<=nx && nx<N && 0<=ny && ny<M) {
						// 키가 있었던 방문 배열과 없었던 방문 배열을 가지고 있어야함
						if(!visited[nx][ny][p.key]) {
							// 벽일때는 못감
							if(array[nx][ny] == '#') continue;
							
							// 다음좌표가 문인 경우
							if('A' <= (int)array[nx][ny] && (int)array[nx][ny] <= 'F') {
								// 키를 가지고 있는지?
								int nk = p.key & (1 << (array[nx][ny] - 'A'));
	
								if (0 < nk) {
									q.add(new Point(nx,ny,p.key));
								}else {
									continue;
								}
							}
							
							// 민식이도 넘어 다녀야 함
							// 메모리 초과 코드
	//						if(array[nx][ny] == '.' || array[nx][ny] == '1' || array[nx][ny] == '0') {
							visited[nx][ny][p.key] = true;
							q.add(new Point(nx,ny,p.key));
	//						}
							
							// 다음 좌표가 키인 경우
							if('a' <= (int)array[nx][ny] && (int)array[nx][ny] <= 'f') {
								// 키 포함 시키기
								int nk = p.key | (1 << (array[nx][ny] - 'a'));
	//							// 키를 가지고 있지 않는 경우
								if(!visited[nx][ny][nk]) {
									visited[nx][ny][nk] = true;
								}
								q.add(new Point(nx,ny,nk));
							}
						}
					}
				}
			}
			
			depth+=1;
		}
		
		System.out.println("-1");
		return;
	}
}