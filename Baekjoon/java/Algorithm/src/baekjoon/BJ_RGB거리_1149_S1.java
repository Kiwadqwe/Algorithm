package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_RGB거리_1149_S1 {
	static int N;
	static int[][] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		array = new int[N+1][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < 3; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N; i++) {
			array[i][0] = Math.min(array[i-1][1], array[i-1][2])+array[i][0];
			array[i][1] = Math.min(array[i-1][0], array[i-1][2])+array[i][1];
			array[i][2] = Math.min(array[i-1][0], array[i-1][1])+array[i][2];
		}
		
		System.out.println(Math.min(array[N-1][0], Math.min(array[N-1][1], array[N-1][2])));
	}
}