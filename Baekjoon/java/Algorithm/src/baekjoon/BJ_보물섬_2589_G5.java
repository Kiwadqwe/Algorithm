package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_보물섬_2589_G5 {
	static int L,W,result,cnt;
	static char[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Point{
		int x,y,cnt;
		
		public Point(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		array = new char[L][W];
		visited = new boolean[L][W];
		for (int i = 0; i < L; i++) {
			array[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if(array[i][j] == 'L') {
					go(i,j);
					result = Math.max(result,cnt);
				}
			}
		}
		System.out.println(result-1);
	}

	private static void go(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		visited = new boolean[L][W];
		visited[x][y] = true;
		q.add(new Point(x,y,1));
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size -- > 0) {
				Point p = q.poll();
				x = p.x;
				y = p.y;
				cnt = p.cnt;
				
				for (int i = 0; i < 4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(0<=nx && nx<L && 0<=ny && ny<W) {
						if(!visited[nx][ny] && array[nx][ny] == 'L') {
							visited[nx][ny] = true;
							q.add(new Point(nx,ny,cnt+1));
							}
						}
					}
				}
			}
		}
	}