package swexpertacademy;

import java.io.*;
import java.util.*;

public class 사람네트워크2_1263 {
	static int TC,N;
	static int[][] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		int INF = 1000001;
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			array = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					array[i][j] =  Integer.parseInt(st.nextToken());
					
					if(array[i][j] == 0 && i != j)	array[i][j] = INF;
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					// 출발지에서 경유가 같은 경로이면
					if(i == k) continue;
					for (int j = 0; j < N; j++) {
						// 출발지랑 도착지랑 같은지 경유와 도착지와 같은지
						if(i == j || k == j) continue;
							array[i][j] = Math.min(array[i][k] + array[k][j], array[i][j]);
						}
					} 
				}

			int result = INF;
			for (int i = 0; i < N; i++) {
				int tp = 0;
				for (int j = 0; j < N; j++) {
					tp += array[i][j];
				}
				
				result = Math.min(tp, result); 
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}