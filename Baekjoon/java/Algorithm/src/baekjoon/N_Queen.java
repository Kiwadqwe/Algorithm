package baekjoon;

import java.util.Scanner;

public class N_Queen {
	static int N,cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		dfs(0, new int [N]);
		System.out.println(cnt);
	}

	private static void dfs(int row, int[] choosed) {
		if(row == N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			choosed[row] = i;
			dfs(row+1,choosed);
			choosed[row] = 0;
			
		}
	}

	private static boolean check(int i, int j, int row, int k) {
		// TODO Auto-generated method stub
		return false;
	}

}
