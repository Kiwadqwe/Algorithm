package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_차이를최대로_10819_S2 {
	static int N,hap,result;
	static int array[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		permu(N,new int[N], new boolean[N]);
		System.out.println(result);
	}

	private static void permu(int idx, int[] choosed, boolean[] visited) {
		if(idx == 0) {
			hap = 0;
//			System.out.println(Arrays.toString(choosed));
			for (int i = 1; i < N; i++) {
				hap += Math.abs(choosed[i-1]-choosed[i]);
			}
			result = Math.max(result, hap);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[choosed.length - idx] = array[i];
				permu(idx-1,choosed,visited);
				visited[i] = false;
			}
		}
	}
}