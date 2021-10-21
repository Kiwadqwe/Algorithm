package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_17142_연구소3_G4 {
	static int N,M,result,safe_cnt;
	static int[][] array;
	static List<Point> safe;
	static Point[] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static Queue<Point> q = new LinkedList<>();
	
	public static class Point {
		int x,y,time = 0;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Point(int x, int y,int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][N];
		safe = new ArrayList<>();
		arr = new Point[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				
				if(array[i][j] == 2) {
					safe.add(new Point(i,j));
				}else if(array[i][j] == 0) {
					safe_cnt += 1;
				}
			}
		}
		
		// 빈칸이 없을 경우
		if(safe_cnt == 0) {
			System.out.println("0");
			System.exit(0);
		}

		result = Integer.MAX_VALUE;
		comb(0,0);
		
		System.out.println(result == Integer.MAX_VALUE ? "-1" : result);
	}

	private static void comb(int idx, int start) {
		if(idx == M) {
			int time = bfs();
			
			// 바이러스 바이러스 위치 체크
			result = Math.min(result,time);

			return;
		}
		
		for (int i = start; i < safe.size(); i++) {
			arr[idx] = safe.get(i);
			comb(idx+1, i+1);
		}
	}

	private static int bfs() {
		visited = new boolean[N][N];

		for (Point point : arr) {
			q.add(point);
			visited[point.x][point.y] = true;		
		}
		
		int count = 0;
		int maxTime = 0;

		while(!q.isEmpty()) {
				Point p = q.poll();
//				if(maxTime < p.time) maxTime = p.time;
//				if(array[p.x][p.y] == 0) count++;
				for (int i = 0; i < 4; i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					maxTime = p.time;
					
					if(0<=nx && nx<N && 0<=ny && ny<N) {
						if(!visited[nx][ny] && array[nx][ny] != 1) {
							if(array[nx][ny] == 0) count++;
							// 빈칸일때만 바이러스를 퍼트리기
							visited[nx][ny] = true;
							q.add(new Point(nx,ny, p.time+1));
						}
					}
				}
				
				if(safe_cnt == count) {
					maxTime++;
					break;
				}
			}
//		return Integer.MAX_VALUE;
		if(count != safe_cnt) return Integer.MAX_VALUE;
		return maxTime;
		}
	}