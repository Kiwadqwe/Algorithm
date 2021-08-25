package swexpertacademy;

import java.io.*;
import java.util.*;

public class 창용마을무리의수_7465 {
	static int N,M;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			make();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			int[] cnt = new int[N+1];
			
			for (int i = 1; i < parents.length; i++) {
				cnt[parents[i]] = 1;
			}
			
			int count = 0;
			for (int i = 0; i < cnt.length; i++) {
				if(cnt[i] >= 1) count+=1; 
			}
			
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		if(aRoot < bRoot) { 
			parents[bRoot] = aRoot;
			
			for(int i = 1; i < N+1; i++) {
				if(parents[i] == bRoot) parents[i] = aRoot;
			}
		}else {
			parents[aRoot] = bRoot;
			
			for(int i = 1; i < N+1; i++) {
				if(parents[i] == aRoot) parents[i] = bRoot;
			}
		}
		return true;
	}

	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		for (int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
	}
}