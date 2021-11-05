package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_부분수열의합_1182_S2 {
	static int N,S,cnt,hap;
	static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
	
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(new int[N], 0, 0);
		
//		powerset();
		System.out.println(cnt);
	}

	private static void subset(int[] select, int start, int idx) {
		if(idx == array.length) {
			// 공집합 처리
			if(start == 0) return;
			
			int sum = 0;
			
			for (int i = 0; i < start; i++) {
				sum += select[i];
			}
			
			if(sum == S) cnt++;
			
			return;
		}
		
		subset(select,start,idx+1);
		select[start] = array[idx];
		subset(select,start+1,idx+1);
	}
	
	private static void powerset() {
		for (int i = 1; i < (1<<array.length); i++) {
			hap = 0;
			List<Integer> arr = new ArrayList<>();
			for (int j = 0; j < array.length; j++) {
				if((i &(1<<j)) != 0) {
					arr.add(array[j]);
				}
			}
			System.out.println(arr);
			for (int j = 0; j < arr.size(); j++) {
				hap += arr.get(j);
			}
			if(hap == S) cnt += 1;
		}
	}
}
