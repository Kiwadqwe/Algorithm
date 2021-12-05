package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_맥주마시면서걸어가기_9205_S1 {
	static int n;
	static ArrayList<int[]> arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < TC; t++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new ArrayList<>();
			
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
					arr.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
				}
			
			boolean[][] d = new boolean[n+2][n+2];
			for (int i = 0; i < n+2; i++) {
				for (int j = i; j < n+2; j++) {
					if(i == j) continue;
					int tp = Math.abs(arr.get(i)[0]-arr.get(j)[0]) + Math.abs(arr.get(i)[1]-arr.get(j)[1]);
					
					if(tp <= 1000) {
						d[i][j] = true;
						d[j][i] = true;
					}
				}
			}
			
			for (int k = 0; k < n+2; k++) {
				for (int i = 0; i < n+2; i++) {
					if(i == k) continue;
					for (int j = 0; j < n+2; j++) {
						if(i == j || j == k) continue;
						if(d[i][k] && d[k][j]) {
							d[i][j] = true;
						}
					}
				}
			}
			
			sb.append(d[0][n+1] ? "happy":"sad").append("\n");
		}
		System.out.println(sb);
	}
}