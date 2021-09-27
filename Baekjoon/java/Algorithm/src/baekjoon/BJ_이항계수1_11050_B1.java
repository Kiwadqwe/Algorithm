package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_이항계수1_11050_B1 {
	static int N,K,cnt;
	static int[] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		comb(K,new int[K],0);
		System.out.println(cnt);
	}

	private static void comb(int idx, int[] choosed, int start) {
		if(idx == 0) {
			cnt+=1;
			return;
		}
		
		for (int i = start; i < array.length; i++) {
			choosed[choosed.length-idx] = array[i];
			comb(idx-1, choosed, i+1);
		}
	}
}