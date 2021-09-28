package swexpertacademy;

import java.io.*;
import java.util.*;

public class 원점으로집합_8458_D4 {
	static int TC,N,result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			boolean even = false;
			boolean odd = false;
			int tp = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));

				tp = Math.max(tp, a);
				
				// 둘이 다르면 홀수 1, 짝수 1 
				// even true면 짝수
				if(a%2 == 0) even = true;
				// odd true면 홀수
				else odd = true;
			}

			// 홀수1, 짝수1 일때
			if(even && odd) {
				sb.append("#").append(t).append(" ").append("-1").append("\n");
				continue;
			}
			
			// 둘다 홀수이거나 짝수 일때
			int hap = 0;
			for (int i = 0; i < 1000000001; i++) {
				hap += i;
				// hap과 tp의 값이  같아질 수 없는 경우도 있음
				if(tp <= hap && tp%2 == hap%2) {
					result = i;
					break;
				}
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}