package swexpertacademy;

import java.io.*;
import java.util.*;

public class 백만장자프로젝트_1859 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] array = new int[N];
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				array[j] = Integer.parseInt(st.nextToken());
			}
			long hap = 0;
			int max = array[N-1];
			
			for (int i = N-2; i >= 0; i--) {
				if(array[i] < max) {
					hap += max - array[i];
				}else {
					max = array[i];
				}
			}
			sb.append("#").append(t).append(" ").append(hap).append("\n");
		}
		System.out.println(sb);
	}
}