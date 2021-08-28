package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_색종이2_2567_S5 {
	static int N;
	static int[][] array;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
 	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		array = new int[101][101];
		int hap = 0;
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					array[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(array[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(array[nx][ny] == 0) {
							hap += 1;
						}
					}
				}
			}
		}
		System.out.println(hap);
	}
}