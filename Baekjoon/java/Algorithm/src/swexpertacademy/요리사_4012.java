package swexpertacademy;

import java.io.*;
import java.util.*;

public class 요리사_4012 {
	static int N,result;
	static int[][] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			array = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MAX_VALUE;
			powe(N/2,new boolean[N],0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void powe(int idx,boolean[] choosed,int start) {
		if(idx == 0) {
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if(choosed[i]) {
					A.add(i);
					
				}else {
					B.add(i);
				}
			}
			
			int ahap = 0;
			int bhap = 0;
			for (int i = 0; i < A.size()-1; i++) {
				for (int j = i+1; j < A.size(); j++) {
					ahap += array[A.get(i)][A.get(j)] + array[A.get(j)][A.get(i)];
					bhap += array[B.get(i)][B.get(j)] + array[B.get(j)][B.get(i)];
				}
			}
			result = Math.min(result, Math.abs(ahap-bhap));
			return;
		}
		
		for (int i = start; i < N; i++) {
			choosed[i] = true;
			powe(idx-1,choosed,i+1);
			choosed[i] = false;
		}
	}
}