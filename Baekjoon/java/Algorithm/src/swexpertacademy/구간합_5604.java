package swexpertacademy;

import java.io.*;
import java.util.*;

public class 구간합_5604 {
	static int TC;
	static long A,B;
	static long[] cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			// 범위가 10^15 이므로 Long으로 받음
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			long delta = 1;
			
			// 각 숫자별로 
			cnt = new long[10];
			while(A<=B) {
				// 앞에 자리수가 작은것, 작은거에서 올라감
				for (; A%10!=0 && A<=B; A++) {
					parse(A,delta);
					
				}
				// 앞에 자리수가 큰것 , 큰거에서 내려옴
				for (; B%10!=9 && A<=B; B--) {
					parse(B,delta);
				}

				// 올라가다가 B보다 크면 탈출
				if(A>B) break;
				// row의 개수
				A /= 10;
				B /= 10;
				
				// 0~9까지가 rowCnt만큼 사용된다.
				// A,B 십의자리 수를 제외한 A~B 사이에 10의 자리수의 개수
				long rowCnt = B-A+1;
				for (int i = 0; i < 10; i++) {
					cnt[i] += delta * rowCnt;
				}
				
				delta *= 10;
			}
			
			long sum = 0;
			for (int i = 1; i < 10; i++) {
				sum += i*cnt[i];
			}
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

	private static void parse(long x, long delta) {
		while(x > 0) {
			cnt[(int)(x%10)] += delta;
			x /= 10;
		}
	}
}