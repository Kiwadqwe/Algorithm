package baekjoon;

import java.util.*;

public class BJ_N_Queen_9663_G5 {
	static int N,cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		dfs(0,new int[N]);
		System.out.println(cnt);
	}

	private static boolean check(int r, int c, int r2, int c2) {
		if(c == c2) return false;
		// abs 안쓸려고 + - 한거 다 구하는거
		if(r-c == r2-c2) return false;
		if(r+c == r2+c2) return false;
		return true;
	}

	private static void dfs(int row, int[] choosed) {
		if(row == N) {
//			System.out.println(Arrays.toString(choosed));
			cnt += 1;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			
			for (int j = 0; j <= row-1; j++) {
				if(!check(row,i,j,choosed[j])) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				choosed[row] = i;
				dfs(row+1,choosed);
				choosed[row] = 0;
			}
		}
	}
	
//	private static boolean check(int col,ArrayList<Integer> choosed) {
//		int row = choosed.size();
//		
//		for (int i = 0; i < row; i++) {
//			// 수직, 대각선 검사
//			// col이 같으면 수직,row-row 와 col-col이 같으면 대각선
//			if((col == choosed.get(i)) || Math.abs(choosed.get(i) - col) == row-i) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	private static void dfs(int row, ArrayList<Integer> choosed) {
//		if(row == N) {
////			System.out.println(choosed);
//			cnt += 1;
//			return;
//		}
//		
//		for (int i = 0; i < N; i++) {
//			if(check(i,choosed)) {
//				choosed.add(i);
//				dfs(row+1,choosed);
//				choosed.remove(choosed.size()-1);
//			}
//		}
}