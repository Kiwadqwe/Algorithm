package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_수들의합2_2003_S3 {
	static int N,M;
	static int[] array;
	static long sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0, result = 0;
		
		while(start<N) {
			// 합이 될때
			if(sum == M) {
				start += 1;
				result += 1;
				sum -= array[start-1];
			// sum이 M을 넘을때 end가 N을 넘을때
			}else if(M < sum || N <= end) {
				start += 1;
				sum -= array[start-1];
			// 현재 sum이 목표치 M 보다 작을때
			}else if(sum < M) {
				end += 1;
				sum += array[end-1];
			}
		}
		System.out.println(result);
	}
}