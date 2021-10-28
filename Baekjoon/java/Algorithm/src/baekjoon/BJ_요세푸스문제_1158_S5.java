package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_요세푸스문제_1158_S5 {
	static int N,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		List<Integer> arr = new ArrayList<>();
		
		for (int i = 1; i < N+1; i++) {
			q.add(i);
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt+=1;
			if (cnt == K) {
				cnt = 0;
				arr.add(q.poll());
			}else {
				q.add(q.poll());
			}
		}
		
		sb.append("<");
		for (int i = 0; i < arr.size()-1; i++) {
			sb.append(arr.get(i)+", ");
		}
		sb.append(arr.get(arr.size()-1)+">");

		System.out.println(sb);
	}
}