package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BJ_일곱난쟁이_2309_B2 {
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		array = new int[9];
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Integer.parseInt(st.nextToken());
		}

		comb(new int[7],0,7);
	}

	private static void comb(int[] arr, int start, int idx) {
		if(idx == 0) {
			int sum = IntStream.of(arr).sum();
			
			if(sum == 100) {
				IntStream list = Arrays.stream(arr);
				Arrays.sort(arr);
				list.forEach(a -> System.out.println(a));
				return;
			}
			
			return;
		}
		
		for (int i = start; i < array.length; i++) {
			arr[arr.length-idx] = array[i];
			comb(arr,i+1,idx-1);
		}
	}
}