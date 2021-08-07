package swexpertacademy;

import java.io.*;
import java.util.*;

public class 퍼펙트셔플_3499_D3 {
	static int TC,N;
	static String[] array;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			array = new String[N];
			for (int i = 0; i < N; i++) {
				array[i] = st.nextToken();
			}
			
			List<String> temp = new ArrayList<>();
			for (int k = 0; k < N/2; k++) {
				if(N%2 == 0) {
					for (int i = k; i < N; i+= N/2) {
						temp.add(array[i]);
					}
				}else {
					for (int i = k; i < N; i+= N/2+1) {
						temp.add(array[i]);
					}
				}	
			}	
			if(N%2 != 0) {
				temp.add(array[N/2]);
			}
			
			sb.append("#"+t+" ");
			for (int i = 0; i < temp.size(); i++) {
				sb.append(temp.get(i)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}