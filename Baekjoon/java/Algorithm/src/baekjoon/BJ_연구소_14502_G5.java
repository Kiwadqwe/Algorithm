package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_연구소_14502_G5 {
	static int[][] map,tp;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int n,m,virus_cnt,result,wall_cnt,virus_tp;
	static ArrayList<Point> virus_a,safe_a;
    static Point[] list = new Point[3];

	public static class Point {
		int x,y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		tp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		safe_a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(tp[i][j] == 0) {
					safe_a.add(new Point(i,j));
				}
				else if(tp[i][j] == 1) {
					wall_cnt +=1;
				}else if(tp[i][j] == 2) {
					virus_tp +=1;
				}
			}
		}
		combination(0,0);
		System.out.println(result);
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void combination(int idx, int start) {
		if(idx == 3) {
		  for (int i = 0; i < tp.length; i++) {
			 System.arraycopy(tp[i], 0, map[i], 0, map[i].length);
		  }
			for(Point p: list) {
				map[p.x][p.y] = 1;
			}
			virus_cnt = 0;
			virsu_search();
			
			result = Math.max(result, n*m-virus_cnt-wall_cnt-3-virus_tp);
			return;
		}
		
		for (int i = 0; i < safe_a.size(); i++) {
			list[idx] = safe_a.get(i);
			combination(idx+1,i+1);
		}
	}
	
	private static void virsu_search() {
		boolean visited[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visited[i][j]) {
					if (map[i][j] == 2) {
						virus(visited, new Point(i,j));
					}
				}
			}
		}
	}
	
	private static void virus(boolean[][] visited,Point point) {
		Queue<Point> q = new LinkedList<Point>();	
		q.add(point);
		visited[point.x][point.y] = true;
		map[point.x][point.y] = 2;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i]+p.x;
				int ny = dy[i]+p.y;
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(!visited[nx][ny]) {
						if(map[nx][ny] == 0) {
							map[nx][ny] = 2;
							virus_cnt +=1;
							visited[nx][ny] = true;
							q.add(new Point(nx,ny));
						}
					}
				}
			}
		}
	}
}