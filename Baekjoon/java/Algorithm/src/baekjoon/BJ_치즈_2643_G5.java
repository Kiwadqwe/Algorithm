package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_치즈_2643_G5 {
	static int n,m,map[][],time,cnt;
	static boolean visited[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	
	public static class Point {
		int x,y;
		
		Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print();
		go();
		
		System.out.println(time);
		System.out.println(cnt);
	}

	private static void go() {
		time = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1){
					bfs(new Point(0,0));
					time += 1;
				}
			}
		}
	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(point);
		visited = new boolean[n][m];
		visited[0][0] = true; 
		map[0][0] = 0;
		cnt = 0;
//		
		while(!q.isEmpty()){
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i]+p.x;
				int ny = dy[i]+p.y;
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(!visited[nx][ny]) {
						if(map[nx][ny] == 1) {
							map[nx][ny] = 0;
							cnt++;
						}
						else {
							q.add(new Point(nx,ny));
						}
						visited[nx][ny] = true;
					}
				}
			}
		}
	}

//	private static void print() {
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}
}
