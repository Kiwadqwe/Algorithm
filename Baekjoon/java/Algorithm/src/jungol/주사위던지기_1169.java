package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class 주사위던지기_1169 {
	static int N,M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		if(M == 1) {
			permuta(N,new int[N],0);
		}else if(M == 2) {
			comb(N,new int[N],1);
		}else if(M == 3) {
			permu(N,new int[N],new boolean[7]);
//			
		}
	}

	private static void permuta(int idx, int[] choosed, int start) {
		if(idx == 0) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for (int j = 1; j <= 6; j++) {
			choosed[choosed.length-idx] = j;
			permuta(idx-1,choosed, j+1);
		}
	}
	
	private static void comb(int idx, int[] choosed, int start) {
		if(idx == 0) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for (int j = start; j <= 6; j++) {
			choosed[choosed.length-idx] = j;
			comb(idx-1,choosed, j);
		}
	}

	private static void permu(int idx, int[] choosed, boolean[] visited) {
		if(idx == 0) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[choosed.length-idx] = i;
				permu(idx-1,choosed,visited);
				visited[i] = false;
				
			}
		}
	}
}
