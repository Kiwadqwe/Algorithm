package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_행렬제곱_10830_G4 {
	static int N,T = 1000;
	static int[][] array,temp;
	static long B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken()) % T;
			}
		}
		
		int[][] mm = matrix(B);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mm[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int[][] matrix(long y) {
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			res[i][i] = 1;
		}
		
		while(0L < y) {
			if(y % 2 == 1L) {
				res = mul(res,array);
			}
			
			y /= 2L;
			res = mul(res,array);
		}
		return res;
	}

	private static int[][] mul(int[][] r, int[][] x) {
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int t = 0;
				for (int k = 0; k < N; k++) {
					// 00 * 10 + 01 *10 
					t = (t % T + (r[i][k] * x[k][j]) % T) % T;
				}
				res[i][j] = t % T;
			}
		}
		System.out.println(Arrays.deepToString(res));
		return res;
	}
}