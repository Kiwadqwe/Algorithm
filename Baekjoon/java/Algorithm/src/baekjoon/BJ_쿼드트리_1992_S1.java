package baekjoon;

import java.io.*;

public class BJ_쿼드트리_1992_S1 {
	static int N;
	static int[][] array;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				array[i][j] = s.charAt(j) - '0';
			}
		}
		
		go(0,0,N);
		System.out.println(sb);
	}

	private static boolean check(int x, int y, int len) {
		for (int i = x; i < x+len; i++) {
			for (int j = y; j < y+len; j++) {
				if(array[i][j] != array[x][y]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void go(int x, int y, int len) {
		if(check(x,y,len)) {
			sb.append(array[x][y]);
		}else {
			sb.append("(");
			int l = len/2;
			go(x,y,l);
			go(x,y+l,l);
			go(x+l,y,l);
			go(x+l,y+l,l);
			sb.append(")");
		}
	}
}