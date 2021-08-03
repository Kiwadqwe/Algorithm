package baekjoon;

import java.util.Scanner;

public class BJ_하노이탑이동순서_11729_S2 {
	static int n,cnt;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sb = new StringBuilder();
		
		hanoi(n,1,2,3);
		System.out.println(cnt);
		System.out.println(sb);
	}
	private static void hanoi(int n, int start, int temp, int dest) {
		if(n==0) return;
		cnt +=1;
		hanoi(n-1,start,dest,temp);
		sb.append(start+" "+dest+"\n");
		hanoi(n-1,temp,start,dest);
	}
}