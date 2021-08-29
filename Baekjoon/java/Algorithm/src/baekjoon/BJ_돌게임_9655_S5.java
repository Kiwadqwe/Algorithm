package baekjoon;

import java.util.Scanner;

public class BJ_돌게임_9655_S5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if(N%2 != 0) System.out.println("SK");
		else System.out.println("CY");
	}
}