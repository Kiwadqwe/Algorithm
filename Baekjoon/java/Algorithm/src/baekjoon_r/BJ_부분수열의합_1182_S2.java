package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_부분수열의합_1182_S2 {
	static int N,S,cnt;
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0,0);
		
		// S가 0일땐 공집합 포함하므로
		if(S == 0) cnt--;
		
		System.out.println(cnt);
	}

	private static void subset(int sum, int idx) {
		if(idx == N) {
			if(sum == S) cnt++;
			return;
		}
		
		subset(sum+array[idx],idx+1);
		subset(sum,idx+1);
	}

}