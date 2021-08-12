package baekjoon;

import java.io.*;

public class BJ_백설공주와일곱난쟁이_3040_B2 {
	static int[] array,result;
	static int tp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		array = new int[9];
		for (int i = 0; i < 9; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		makeCombination(7, new int[7],0);
		
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]+"\n");
		}
		
		System.out.println(sb);
	}
	
	static void makeCombination(int toChoose, int [] choosed, int startIdx) {
		if(toChoose==0) {
			tp = 0;
			for (int i = 0; i < choosed.length; i++) {
				tp += choosed[i];
			}
			if (tp == 100) {
				result = choosed.clone();
			}
			return;
		}
		
		for(int i=startIdx; i<array.length; i++) {
			choosed[choosed.length-toChoose] = array[i];
			makeCombination(toChoose-1, choosed, i+1);
		}
	}
}