package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_단지번호붙이기_2667_S1 {
	static int n,cnt;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static boolean visited[][]; 
	static Point[] list = new Point[3];
	
	public static class Point {
		int x,y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb =  new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new boolean[n][n];
		List<Integer> array = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int dang = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!(visited[i][j]) && map[i][j] == 1) {
					dang +=1;
					bfs(new Point(i,j),dang);
					array.add(cnt);
					cnt = 0;
				}
			}
		}
		
		System.out.println(dang);
		Collections.sort(array);
		for (Integer arr : array) {
			sb.append(arr+"\n");
		}
		System.out.print(sb);
	}
	
	private static void bfs(Point point, int dang) {
		Queue<Point> q = new LinkedList<>();
		q.add(point);
		visited[point.x][point.y] = true;
		map[point.x][point.y] = dang;
		cnt = 1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i]+p.x;
				int ny = dy[i]+p.y;
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(map[nx][ny] == 1) {
						if(!(visited[nx][ny])) {
							map[nx][ny] = dang;
							visited[nx][ny] = true;
							cnt +=1;
							q.add(new Point(nx,ny));
						}
					}
				}
			}
		}
	}
}