package swexpertacademy;

import java.io.*;
import java.util.*;

public class 성수의비밀번호공격_6026 {
	static int TC,M,N;
	static int MOD = 1_000_000_007;
	static long[] fac;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(st.nextToken());
		
		// 모든 케이스에서 사용할거니깐 한번만 사용하게
		// factorial
		fact();
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			long result = solve();
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	// ∑(-1)^i * kCi * (k-i)^n
	private static long solve() {
		long total = 0l;
		for (int i = 0; i <= M; i++) {
			long l1 = (i % 2 == 0 ? 1 : -1);
			long l2 = nCr(i);
			long l3 = pow(M-i, N);
			
			// 그냥 하면 l1의 영향으로 음수가 나올 수 있으므로.. MOD를 한번 더해줘서 양수로 만들어주자.
			long result = (MOD + l1 *(l2*l3)%MOD)%MOD;
			total = (total + result) %MOD;
		}
		return total;
	}

	// a^b을 분할정복을 이용한 빠른 거듭제곱으로 처리
	private static long pow(long a, int b) {
		if(b == 1) {
			return a;
		}
		
		long half = pow(a,b/2);

		// 짝수승 일때 - half * half, 홀수승 일때 - half * half * a
		if(b%2 == 0) {
			return (half*half)%MOD;
		}else {
			// 나머지 연산의 분배법칙
			return ((half*half)%MOD*a)%MOD;
		}
	}

	private static long nCr(int r) {
		if(r == 0) {
			return 1;
		}
		long l1 = fac[M];
		long l2 = pow(fac[M-r], MOD-2);
		long l3 = pow(fac[r], MOD-2);
		long result = ((l1*l2)%MOD*l3)%MOD;
		
		return result;
	}

	private static void fact() {
		// N과 M이 100까지므로
		fac = new long[101];
		fac[0] = fac[1] = 1;
		for (int i = 2; i < fac.length; i++) {
			// 숫자가 너무 커지니깐 MOD로 나눠버림
			fac[i] = (fac[i-1] * i) % MOD;
		}
	}
}