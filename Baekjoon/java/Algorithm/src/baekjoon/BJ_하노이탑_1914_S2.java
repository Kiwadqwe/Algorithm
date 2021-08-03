package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;
	
public class BJ_하노이탑_1914_S2 {
	static StringBuilder sb;
	static int n,cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		n = sc.nextInt();
		
		if(n<=20) {
			hanoi(n,1,2,3);
			System.out.println(cnt);
			System.out.println(sb);
		// n이 21 이상이면
		}else {
			BigInteger bi = new BigInteger("2");
			BigInteger c = bi.pow(n).subtract(BigInteger.ONE);
			System.out.println(c);
		}
	}

	private static void hanoi(int n, int start, int temp, int dest) {
		if(n == 0) return;
		cnt += 1;
		hanoi(n-1,start,dest,temp);
		sb.append(start+" "+dest+"\n");
		hanoi(n-1,temp,start,dest);
	}
}