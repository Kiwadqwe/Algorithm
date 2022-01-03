package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_숫자정사각형_1051_S3 {
	static int N,M;
	static int[][] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				array[i][j] = s.charAt(j) - '0';
			}
		}

		int result = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 1; k+i < N && k+j < M; k++) {
					if(array[i][j] == array[i][j+k] && 
							array[i][j] == array[i+k][j] && 
							array[i][j] == array[i+k][j+k]) {
						// 가장 큰 정사각형 넓이 구하기
						int temp = (k+1) * (k+1);
						result = Math.max(temp, result);
					}
				}
			}
		}
		
		System.out.println(result);
	}
}