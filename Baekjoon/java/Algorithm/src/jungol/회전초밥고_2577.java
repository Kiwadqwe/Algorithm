package jungol;

import java.io.*;
import java.util.*;

public class 회전초밥고_2577 {
	static int N,d,k,c;
	static int[] array;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		visited = new int[d+1];
		array = new int[N+k];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			array[N+i] = array[i];
			if(visited[array[i]] == 0) cnt+=1;
			visited[array[i]] += 1;
		}
		
		if(visited[c] == 0) cnt+=1;
		visited[c] += 1;
		
		int start = array[0];
		int result = cnt;

		for (int i = 0; i < N; i++) {
			visited[start] -= 1;
			if(visited[start] == 0) cnt-=1;
			if(visited[array[i+k]] == 0) cnt+=1;
			visited[array[i+k]] += 1;
			
			start = array[i+1];
			
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
	}
}