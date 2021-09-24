package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_미세먼지안녕_17144_G4 {
	static int R,C,T,cnt;
	static int[][] array;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Point> q;
	static List<Point> arr;
	
	public static class Point {
		int x,y,tp;
		
		public Point(int x, int y, int tp) {
			this.x = x;
			this.y = y;
			this.tp = tp;
		}
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
		T = Integer.parseInt(st.nextToken());
		
		array = new int[R][C];
		arr = new ArrayList<>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				
				if(array[i][j] == -1) {
					arr.add(new Point(i,j));
				}
			}
		}
		
		for (int k = 0; k < T; k++) {
			q = new LinkedList<Point>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {	
					if(0 < array[i][j]) {
						q.add(new Point(i,j,array[i][j]));
					}
				}
			}
			
			bfs();
			go();
		}
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(array[i][j] != -1 || array[i][j] == 0) {
					result += array[i][j];
				}
			}
		}
		
		System.out.println(result);
	}

	private static void go() {
		// 상
		for (int k = 0; k < arr.size(); k+=2) {
			// 좌
			for (int j = arr.get(k).x -1; j > 0; j--) {
				array[j][0] = array[j-1][0];
			}
			// 위
			for (int j = 0; j < C-1; j++) {
				array[0][j] = array[0][j+1];
			}
			// 우
			for (int j = 0; j < arr.get(k).x; j++) {
				array[j][C-1] = array[j+1][C-1];
			}
			// 아래
			for (int j = C-1; j > 1; j--) {
				array[arr.get(k).x][j] = array[arr.get(k).x][j-1];
			}
			array[arr.get(k).x][1] = 0;
		}
		//하
		for (int k = 1; k < arr.size(); k+=2) {
			// 좌
			for (int j = arr.get(k).x+1; j < R-1; j++) {
				array[j][0] = array[j+1][0]; 
			}
			// 아래
			for (int j = 0; j < C-1; j++) {
				array[R-1][j] = array[R-1][j+1];
			}
			// 우
			for (int j = R-1; j > arr.get(k).x; j--) {
				array[j][C-1] = array[j-1][C-1];
			}
			// 위
			for (int j = C-1; j > 1; j--) {
				array[arr.get(k).x][j] = array[arr.get(k).x][j-1];
			}
			array[arr.get(k).x][1] = 0;
		}
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.tp < 5) continue;
			cnt = 0;
			int d = p.tp/5;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<R && 0<=ny && ny<C) {
					if(array[nx][ny] != -1) {
						array[nx][ny] += d; 
						cnt += 1;
					}
				}
			}
			array[p.x][p.y] -= d*cnt;
		}
	}
}