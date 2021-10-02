package baekjoon;

import java.util.*;

public class BJ_책페이지_1019_G1 {
	static long N;
	static int[] cnt;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextLong();
		
		cnt = new int[10];
		long d = 1;
		// 시작 페이지
		long M = 1;
		
		while(M<=N) {
			// 작은 수부터 1->9까지
			for (; M%10 != 0 && M<=N; M++) {
				cal(M,d);
			}
			
			// 큰 수부터 8->0까지 
			for (; N%10 != 9 && M<=N; N--) {
				cal(N,d);
			}
			
			// 기저조건
			if(M>N) break;
			
			M /= 10;
			N /= 10;
			
			// 행 구하기
			long rowCnt = N-M+1;
			for (int i = 0; i < 10; i++) {
				cnt[i] += d * rowCnt;
			}
			
			d *= 10;
		}
			
		for (int i = 0; i < 10; i++) {
			System.out.print(cnt[i]+" ");
		}
	}	

	private static void cal(long x, long d) {
		while(x>0) {
			cnt[(int)(x%10)] += d;
			x /= 10;
		}
	}
}