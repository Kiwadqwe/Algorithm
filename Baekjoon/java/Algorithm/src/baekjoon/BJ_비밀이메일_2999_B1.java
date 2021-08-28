package baekjoon;

import java.util.*;

public class BJ_비밀이메일_2999_B1 {
	static char[][] ch;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int x = 0;
		int y = 0;
		for (int i = 1; i <= s.length()/2; i++) {
			for (int j = i; j <= s.length(); j++) {
				if(i*j == s.length() && i <= j) {
					if(x < i) {
						x = Math.max(x,i);
						y = j;
					}
				}
			}
		}
		
		ch = new char[x][y];
		int cnt = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				ch[j][i] = s.charAt(cnt++);
			}
		}
		print();
	}

	private static void print() {
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[0].length;j++) {
				System.out.print(ch[i][j]);
			}
		}
	}
}