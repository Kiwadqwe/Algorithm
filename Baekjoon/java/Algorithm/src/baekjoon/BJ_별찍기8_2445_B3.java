package baekjoon;

import java.util.Scanner;

public class BJ_별찍기8_2445_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= (N-i)*2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = N-1; i >=0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= (N-i)*2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}