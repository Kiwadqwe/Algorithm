package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_불_4179_G4 {
	static int R,C;
	static char[][] array;
	static int[][] j_visited,f_visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Point> q,q2;
	
	public static class Point {
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		array = new char[R][C];
		j_visited = new int[R][C];
		f_visited = new int[R][C];
		q = new LinkedList<Point>();
		q2 = new LinkedList<Point>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < C; j++) {
				array[i][j] = s.charAt(j);
				
				if (array[i][j] == 'J') {
					q2.add(new Point(i,j));
					j_visited[i][j] = 1;
				}
				
				if (array[i][j] == 'F') {
					q.add(new Point(i,j));
					f_visited[i][j] = 1;
				}
			}
		}
		
		bfs();
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];

				// 불을 먼저 퍼트리는데 불을 퍼트릴때 시간을 저장해주자
				if(0<=nx && nx<R && 0<=ny && ny<C) {
					if(f_visited[nx][ny] == 0) {
						if(array[nx][ny] != '#') {
							f_visited[nx][ny] = f_visited[p.x][p.y] + 1;
							q.add(new Point(nx,ny));
						}
					}
				}
			}
		}
		
		while(!q2.isEmpty()) {
			Point p = q2.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || R<=nx || ny<0 || C<=ny) {
					System.out.println(j_visited[p.x][p.y]);
					return;
				}
				
				if(0<=nx && nx<R && 0<=ny && ny<C) {
					if(j_visited[nx][ny] == 0) {
						if(array[nx][ny] != '#') {
							// 불이 퍼진 곳인지 확인 하기 위해서 지훈이가 움직일 좌표가 불이 퍼지는 곳인지 확인
							// 움직이기 전에 퍼지는 곳인지 확인 하기 위해
							if(f_visited[nx][ny]-1 > j_visited[p.x][p.y] || f_visited[nx][ny] == 0) {
								j_visited[nx][ny] = j_visited[p.x][p.y] + 1;
								q2.add(new Point(nx,ny));
								}
							}
						}
					}
				}
			}
		
		System.out.println("IMPOSSIBLE");
		return;
		}
	}