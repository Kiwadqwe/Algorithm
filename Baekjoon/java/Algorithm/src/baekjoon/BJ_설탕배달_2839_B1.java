package baekjoon;

import java.util.Scanner;

public class BJ_설탕배달_2839_B1 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int cnt =0;
		while(true) {
			// 최소의 개수를 구하기 위해서 가장 큰 수로 먼저 나눌 수 있으면 나눔
			if(N%5 == 0) {
				cnt += N/5;
				System.out.println(cnt);
				break;
			// 가장 작은 kg가 3이므로 그 미만은 될 수 없음
			}else if(N < 3) {
				System.out.println("-1");
				break;
			}
			N -= 3;
			cnt += 1;
		}
	}
}