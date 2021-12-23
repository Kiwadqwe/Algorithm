package baekjoon_r;

import java.util.Scanner;

public class BJ_BABBA_9625_B1 {
	static int N;
	static int a_cnt,b_cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a_cnt = 1;
		for (int i = 0; i < N; i++) {
			int A_new = b_cnt;
			int B_new = a_cnt+b_cnt;
			a_cnt = A_new;
			b_cnt = B_new;
		}
		
		System.out.println(a_cnt+" "+b_cnt);
	}


}