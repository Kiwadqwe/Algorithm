package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_13일의금요일_16463_S4 {
	static int N,cnt,d;
	static int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		
		d = 13;

		for (int y = 2019; y <= N; y++) {
			for (int m = 1; m <= 12; m++) {
				if(d % 7 == 4) {
					cnt += 1;
				}
				d += month[m];
				
				if(m == 2 && ((y % 100 != 0 && y % 4 == 0)  || y % 400 == 0)) {
					d += 1;
				}
			}
		}
		System.out.println(cnt);
	}
}