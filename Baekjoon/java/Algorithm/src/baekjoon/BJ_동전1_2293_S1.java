package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_동전1_2293_S1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] array = new int[n];
		int[] dp = new int[k+1];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = array[i]; j < k+1; j++) {
				dp[j] += dp[j-array[i]];
			}
		}
		System.out.println(dp[k]);
	}
}