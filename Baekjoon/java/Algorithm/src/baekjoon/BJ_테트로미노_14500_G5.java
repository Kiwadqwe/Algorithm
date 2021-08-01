package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_테트로미노_14500_G5 {
	static int[][] map;
	static int n,m,tp,result;
	static int[][][] tetromino = {
		    {{0,0},{0,1},{0,2},{0,3}}, 
		    {{0,0},{1,0},{2,0},{3,0}},

		    {{0,0},{0,1},{1,0},{1,1}},
		    
		    {{0,0},{1,0},{2,0},{2,1}},
		    {{0,1},{1,1},{2,0},{2,1}},
		    {{0,0},{1,0},{0,1},{0,2}},
		    {{0,0},{0,1},{0,2},{1,2}},
		    {{0,0},{0,1},{1,1},{2,1}},
		    {{0,0},{0,1},{1,0},{2,0}},
		    {{0,2},{1,0},{1,1},{1,2}},
		    {{0,0},{1,0},{1,1},{1,2}},

		    {{0,0},{1,0},{1,1},{2,1}},
		    {{0,1},{1,1},{1,0},{2,0}},
		    
		    {{0,1},{0,2},{1,0},{1,1}},
		    {{0,0},{0,1},{1,1},{1,2}},

		    {{0,0},{0,1},{0,2},{1,1}},
		    {{0,1},{1,0},{1,1},{1,2}},

		    {{0,1},{1,0},{1,1},{2,1}},
		    {{0,0},{1,0},{2,0},{1,1}},
		    };
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				 move(i,j);
			}
		}
		System.out.println(result);
	}

	private static void move(int x, int y) {
		for (int i = 0; i < 19; i++) {
			tp = 0;
			for (int j = 0; j < 4; j++) {
				int nx = tetromino[i][j][0]+x;
				int ny = tetromino[i][j][1]+y;

				if(0<=nx && nx<n && 0<=ny && ny<m) {
					tp += map[nx][ny];
				}
			}
			result = Math.max(result,tp);
		}
	}
}