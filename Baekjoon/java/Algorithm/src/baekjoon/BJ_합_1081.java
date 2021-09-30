package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_합_1081 {
	static Long L,U;
	static long[] cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Long.parseLong(st.nextToken());
		U = Long.parseLong(st.nextToken());
		
		cnt = new long[10];
		long d = 1;
		
		while(L<=U) {
			// 작은것에서 올라가니깐 9까지
			for (; L%10 != 0 && L<=U; L++) {
				parse(L,d);
			}
			// 큰거에서 내려가니깐 0까지
			for (; U%10 != 9 && L<=U; U--) {
				parse(U,d);
			}
			
			if(L>U) break;
			
			L /= 10;
			U /= 10;
			
			long rowCnt = U-L+1;
			for (int i = 0; i < 10; i++) {
				cnt[i] += d * rowCnt;
			}
			
			d *= 10;
		}
		
		long sum = 0;
		for (int i = 1; i < 10; i++) {
			sum += i*cnt[i];
		}
		
		System.out.println(sum);
	}

	private static void parse(Long x, long d) {
		while(x > 0) {
			cnt[(int)(x%10)] += d;
			x /= 10;
		}
	}
}