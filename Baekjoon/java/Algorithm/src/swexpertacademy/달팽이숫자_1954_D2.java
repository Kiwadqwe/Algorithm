package swexpertacademy;

import java.util.*;

public class 달팽이숫자_1954_D2 {
	static int n,tc,dir,x,y,cnt;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for (int t = 1; t <=tc; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			cnt = 1;
			dir = 1;
			x = 0;
			y = -1;
			while(true) {
				if (n==0) {
					break;
				}
				for (int i = 0; i < n; i++) {
					y += dir;
					map[x][y] = cnt; 
					cnt+=1;
				} 
				n-=1;
				for (int i = 0; i < n; i++) {
					x += dir;
					map[x][y] = cnt;
					cnt+=1;
				}
				dir *=-1;
			}
			System.out.println("#"+t);
			print();
		}
	}
	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}