package swexpertacademy;

import java.io.*;
import java.util.*;

public class 프로세서연결하기_1767 {
	static int N,result,tp;
	static int[][] array;
	static List<Point> arr;
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
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			
			array = new int[N][N];
			arr = new ArrayList<Point>();
			result = Integer.MAX_VALUE;
			tp = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
					
					if(i == 0 || j == 0 || i == N-1 || j == N-1) continue;
					if(array[i][j] == 1) arr.add(new Point(i,j));
				}
			}

			visited = new boolean[N][N];
			go(0,0,0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
		public static void go(int idx, int cnt, int count) {
			if (tp < count) {
				tp = count;
				result = cnt;
				
			} else if (tp == count) {
				result = Math.min(result, cnt);
			}

			if (idx == arr.size()) {
				return;
			}

			Point p = arr.get(idx);
			
			for (int k = 0; k < 4; k++) {
				int nx = p.x;
				int ny = p.y;

				while (true) {
					nx += dx[k];
					ny += dy[k];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						go(idx + 1, cnt, count + 1);
						cnt -= back(k, idx, nx, ny, visited);
						break;
					}

					if (array[nx][ny] == 1 || visited[nx][ny]) {
						cnt -= back(k, idx, nx, ny, visited);
						break;
					}

					visited[nx][ny] = true;
					cnt++;
				}
			}
			go(idx+1, cnt, count);
		}

		public static int back(int k, int idx, int nx, int ny, boolean[][] visited) {
			int cnt = 0;
			Point p = arr.get(idx);

			nx -= dx[k];
			ny -= dy[k];
			
			while (true) {
				if (p.x == nx && p.y == ny) break;

				visited[nx][ny] = false;
				cnt++;
				nx -= dx[k];
				ny -= dy[k];
			}
			return cnt;
		}
	}