package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_숫자놀이_1755_S4 {
	static int M,N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		String[] alpha = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		int[] array = new int[N+1];
		for (int i = M; i <= N; i++) {
			array[i] = i;
		}
		
		String[] tp = new String[N+1]; 
		
		for (int i = M; i <= N; i++) {
			int a = array[i]/10;
			int b = array[i]%10;

			if(a == 0) {
				tp[i] = alpha[b];
			}else {
				tp[i] = alpha[a]+" "+alpha[b];
			}
		}
		
		for (int i = 0; i < tp.length; i++) {
			if(tp[i] == null) {
				tp[i] = "";
			}
		}
		
		Arrays.sort(tp);
		
		String[] result = new String[N-M+1];
		
		for (int i = 0; i < result.length; i++) {
			if(result[i] == null) {
				result[i] = "";
			}
		}
		
		String[] temp = new String[N+1];
		for (int i = M; i <= N; i++) {
			temp = tp[i].split(" ");
			
			for (int j = 0; j < temp.length; j++) {
				for (int k = 0; k < alpha.length; k++) {
					if(alpha[k].equals(temp[j].trim())) {
						result[i-M] += ""+k;
					}
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
			cnt += 1;
			if(cnt == 10) {
				cnt = 0;
				System.out.println();
			}
		}
	}
}