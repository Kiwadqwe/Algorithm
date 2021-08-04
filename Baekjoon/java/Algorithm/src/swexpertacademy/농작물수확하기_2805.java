package swexpertacademy;

import java.io.*;
import java.util.*;

public class 농작물수확하기_2805 {
	static int TC,N,hap,tx,right_x,right_y;
	static int[][] map;
	static int[] dx = {0,1,1};
	static int[] dy = {1,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int x = 0;
			int y = N/2;
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			hap = 0;
			// 첫번째 라인 저장
			calFirst(x,y);
			right_x = 0;
			right_y = N/2;
			int temp = N-2;
			for (int i = 0; i < N/2; i++) {
				// 왼쪽
				tx = calDir(1,x,y,temp);
				// x 초기값 저장
				x = tx-temp;
				y -= 1;
				// 오른쪽
				tx = calDir(2,right_x,right_y,temp);
				right_x = tx-temp;
				right_y += 1;
				temp -= 2;
			}
			sb.append("#"+t+" "+hap+"\n");
		}
		System.out.println(sb);
	}

	private static void calFirst(int x, int y) {
		for (int i = 0; i < N; i++) {
			hap += map[x][y];
			x += 1;
		}
	}

	private static int calDir(int k,int x, int y,int temp) {
		x = dx[k]+x;
		y = dy[k]+y;
		for (int j = 0; j < temp; j++) {
			hap += map[x][y];
			x += 1;
		}
		return x;
	}
}