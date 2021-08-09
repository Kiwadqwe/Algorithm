package swexpertacademy;

import java.io.*;
import java.util.*;

public class 햄버거다이어트_5215_D3 {
	static int TC,N,L,result;
	static int[] taste,cal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <=TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			taste = new int[N];
			cal = new int[N];
			result = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			powerset();
			System.out.println("#"+t+" "+result);
		}
	}

	private static void powerset() {
		for(int i=0; i< (1<<taste.length); i++) {
			int ta = 0;
			int cl = 0;
			
            for(int j=0; j<taste.length; j++) {
                if(0<(i & (1<<j))  ) {
                    ta += taste[j];
                    cl += cal[j];
                }
            }
            if(cl<=L) {
            	result = Math.max(result, ta);
            }
        }
	}
}