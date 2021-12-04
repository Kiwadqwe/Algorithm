package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_롤케이크_3985_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int expect = 0;
		int tp = 0;
		int[] array = new int[L+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = a; j <= b; j++) {
				if(array[j] == 0) {
					array[j] = i;
				}
			}
			if(tp < b-a) {
				tp = b-a;
				expect = i;
			}
		}
		
		int result = 0;
		int temp = 0;
		
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 0; j < array.length; j++) {
				if(array[j] == i) {
					cnt += 1;
				}
			}
			if(temp < cnt) {
				temp = cnt;
				result = i;
			}
		}
		
		System.out.println(expect+"\n"+result);
	}
}