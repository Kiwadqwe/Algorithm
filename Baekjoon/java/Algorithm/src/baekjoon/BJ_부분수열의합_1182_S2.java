package baekjoon;

import java.util.*;

public class BJ_부분수열의합_1182_S2 {
	static int[] array;
	static int N,S,result,hap;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		array = new int[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}
		
		powerset();
		System.out.println(result);
	}

	private static void powerset() {
		for (int i = 1; i < (1<<array.length); i++) {
			hap = 0;
			List<Integer> arr = new ArrayList<>();
			for (int j = 0; j < array.length; j++) {
				if((i &(1<<j)) != 0) {
					arr.add(array[j]);
				}
			}
			for (int j = 0; j < arr.size(); j++) {
				hap += arr.get(j);
			}
			if(hap == S) result += 1;
		}
	}
}