package baekjoon;

import java.io.*;

public class BJ_스도쿠_2239_G4 {
	static int[][] array = new int[9][9];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				array[i][j] = s.charAt(j) - '0';
			}
		}
		
		go(0,0);
	}

	private static void go(int x, int y) {
		if(y == 9) {
			go(x+1,0);
			return;
		}
		
		if(x == 9) {
			print();
			System.exit(0);
		}
		
		if(array[x][y] == 0) {
			for (int k = 1; k <= 9; k++) {
				if(check(x,y,k)
						&& row(y,k)
						&& col(x,k)) {
					array[x][y] = k;
					go(x,y+1);
				}
			}
			// 다른 경우도 보기 위해서
			array[x][y] = 0;
			return;
		}
		// 숫자가 채워져있는 경우
		go(x,y+1);
	}

	private static boolean col(int x, int k) {
		for (int i = 0; i < 9; i++) {
			if(array[x][i] == k) {
				return false;
			}
		}
		return true;
	}

	private static boolean row(int y, int k) {
		for (int i = 0; i < 9; i++) {
			if(array[i][y] == k) {
				return false;
			}
		}
		return true;
	}

	private static boolean check(int x, int y, int k) {
		int nx = x/3 * 3;
		int ny = y/3 * 3;
		
		for (int i = nx; i < nx+3; i++) {
			for (int j = ny; j < ny+3; j++) {
				if(array[i][j] == k) {
					return false;
				}
			}
		}
		
		return true;
	}

	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
}