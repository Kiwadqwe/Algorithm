package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_암호만들기_1759_G5 {
	static int L,C,mo,za;
	static String[] array;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		array = new String[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			array[i] = st.nextToken();
		}
		Arrays.sort(array);
		comb(L, new String[L], 0);
		System.out.println(sb);
	}
	
	private static boolean check(String[] choosed) {
		for (int i = 0; i < L; i++) {
			if(choosed[i].equals("a")) mo+=1;
			else if(choosed[i].equals("e")) mo+=1;
			else if(choosed[i].equals("i")) mo+=1;
			else if(choosed[i].equals("o")) mo+=1;
			else if(choosed[i].equals("u")) mo+=1;
			else za+=1;
		}
		
		if (1 <= mo && 2 <= za) {
			return true;
		}
		
		return false;
	}

	private static void comb(int idx, String[] choosed, int start) {
		if(idx == 0) {
			mo = 0;
			za = 0;
			if (check(choosed)) {
				for (int i = 0; i < choosed.length; i++) {
					sb.append(choosed[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			choosed[choosed.length - idx] = array[i];
			comb(idx-1, choosed, i+1);
		}
	}
}