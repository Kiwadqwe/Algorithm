package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_오목_2615_S3 {
	static int[] dx = {0,1,1,-1};
	static int[] dy = {1,1,0,1};
	static int[][] map;
	static int n,result,r,c;
	static ArrayList<Point> area = new ArrayList<>();
	
	public static class Point{
		int x,y;

		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		area = new ArrayList<>();
		int n = 19;
		map = new int[n][n];
		boolean check = false;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1 || map[i][j] == 2) {
					area.add(new Point(i,j));
				}
			}
		}
		
		for (int i = 0; i < area.size(); i++) {
			int x = area.get(i).x;
			int y = area.get(i).y;
			check = omok(x,y);
			if(check) {
				break;
			}
		}
		if(check) {
			System.out.println(result);
			System.out.println((r+1)+" "+(c+1));
		}else {
			System.out.println("0");
		}
		
	}
	
	private static boolean omok(int a, int b) {
		for (int k = 0; k < 4; k++) {
			int x = a;
			int y = b;
			int cnt = 1;
			while(true) {
				int nx = dx[k]+x;
				int ny = dy[k]+y;
				if(0<=nx && nx<19 && 0<=ny && ny<19) {
					if(map[nx][ny] == map[x][y]) {
						cnt +=1;
						x = nx;
						y = ny;
					}else {
						break;
					}
					if(cnt>5) {
						break;
					}
				}else {
					break;
				}
			}
			if(cnt == 5) {
				if(0<=a-dx[k] && a-dx[k] <19 && 0<=b-dy[k] && b-dy[k] <19) {
					if(map[a][b] == map[a-dx[k]][b-dy[k]]) {
						return false;
					}
				}
				result = map[a][b];
				r = a;
				c = b;
				return true;
			}
		}
		return false;
	}
}