package baekjoon;

import java.util.*;

public class BJ_Z_1074_S1 {
	static int N,r,c,cnt;
	static int[][] array;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		array = new int[N][N];
		
		go(0,0,(int) Math.pow(2, N));
		
	}

	private static void go(int i, int j, int len) {
		if(len == 1) {
			if(i == r && j == c) {
				System.out.println(cnt);
				System.exit(0);
			}else {
				cnt+=1;
			}
			return;
		}
		
		if(i+len <= r || j+len <= c) {
			cnt += len*len;
			return;
		}
		
		go(i,j,len/2);
		go(i,j+len/2,len/2);
		go(i+len/2,j,len/2);
		go(i+len/2,j+len/2,len/2);
	}
}