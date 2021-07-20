package baekjoon;

import java.io.*;
import java.util.*;

import sun.security.util.Length;

public class BJ_알파벳_1987_G4 {
	static int R,C,result;
	static char[][] array;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		array = new char[R][C];
		for (int i = 0; i < R; i++) {
			array[i] = br.readLine().toCharArray();
		}
		String tp = String.valueOf(array[0][0]);
		go(0,0,tp);
		System.out.println(result);
	}

	private static void go(int x, int y, String choose) {
		result = Math.max(result, choose.length());
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(0<=nx && nx<R && 0<=ny && ny<C) {
				if(!choose.contains(String.valueOf(array[nx][ny]))) {
					go(nx,ny,choose+String.valueOf(array[nx][ny]));
				}	
			}
		}
	}
}