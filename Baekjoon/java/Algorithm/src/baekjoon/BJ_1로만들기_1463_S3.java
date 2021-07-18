package baekjoon;

import java.io.*;

public class BJ_1로만들기_1463_S3 {
	static int x;
	static int n[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		x = Integer.parseInt(br.readLine());
		n = new int[x+1];
		dp();
		print();
	}

	private static void print() {
		System.out.println(n[x]);
//		for (int i = 0; i < n.length; i++) {
//			System.out.println(n[i]);
//		}
		}

	private static void dp() {
		for(int i = 2; i<x+1; i++) {
			n[i] = n[i-1]+1;
			if (i%3 == 0) {
				n[i] = Math.min(n[i/3]+1, n[i]);
			}
			if (i%2 == 0) {
				n[i] = Math.min(n[i/2]+1, n[i]);
			}
				
		}
	}
}
