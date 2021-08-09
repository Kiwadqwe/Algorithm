package swexpertacademy;

import java.io.*;
import java.util.*;

public class 한빈이와SpotMart_9229_D3 {
	static int TC,N,M,result;
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			result = 0;
			array = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {	
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(2,new int[2],0);
			
			if(result == 0) {
				sb.append("#"+t+" "+-1+"\n");
			}else {
				sb.append("#"+t+" "+result+"\n");
			}
		}
		System.out.print(sb);
	}
	
	private static void combination(int toChoose, int[] choosed,int startIdx) {
		int hap = 0;
		
		if(toChoose==0) {
			hap = choosed[0]+choosed[1];
			if (hap <= M) {
				result = Math.max(hap, result);
			}
			return;
		}
		
		for (int i = startIdx; i < array.length; i++) {
			choosed[choosed.length-toChoose] = array[i];
			combination(toChoose-1, choosed, i+1);
		}
	}
}