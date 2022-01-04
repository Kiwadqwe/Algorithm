package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_차이를최대로_10819_S2 {
	static int N,result,hap;
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		permu(0,new boolean[N],new int[N]);
		System.out.println(result);
	}
	
	private static void permu(int idx, boolean[] visited, int[] choosed) {
		if(idx == N) {
			for (int i = 1; i < choosed.length; i++) {
				hap += Math.abs(choosed[i-1]-choosed[i]);
			}
			
			result = Math.max(result, hap);
			hap = 0;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[idx] = array[i];
				permu(idx+1,visited,choosed);
				visited[i] = false;
			}
		}
	}
}