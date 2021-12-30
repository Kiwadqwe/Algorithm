package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_줄세우기_2252_G3 {
	static int N,M;
	static int[] indegree;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}

		indegree = new int[N+1];
		for(int i=0; i <M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			indegree[b]++;
			list.get(a).add(b);
		}

		topology();

		System.out.println(sb);
	}

	private static void topology() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<N+1; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()){
			int p = q.poll();
			sb.append(p+" ");
			for (Integer a : list.get(p)) {
				indegree[a] -= 1;
				if(indegree[a] == 0) {
					q.add(a);
				}
			}
		}
	}
}