package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_분해합_2231_B2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int result = 0; 
		
		for(int i = 1; i < N; i++) {
			if(N == cal(i)) {
				result = i;
				break;
			}
		}
		
		System.out.println(result == 0 ? 0 : result);
	}

	private static int cal(int i) {
		int sum = i;
		
		while(0 < i) {
			sum += i%10;
			i /= 10;
		}
		
		return sum;
	}
}