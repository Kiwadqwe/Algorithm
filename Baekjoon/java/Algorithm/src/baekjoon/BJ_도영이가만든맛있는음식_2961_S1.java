package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_도영이가만든맛있는음식_2961_S1 {
	static int N,result,tp,tp2;
	static int[] sin,ss;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		sin = new int[N];
		ss =  new int[N];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			sin[i] = Integer.parseInt(st.nextToken());
			ss[i] = Integer.parseInt(st.nextToken());
		}
		powerset();
		System.out.println(result);
	}
	
	// 부분 집합
	static void powerset() {
        for(int i=0; i< (1<<N); i++) {
            List<Integer> asin = new ArrayList<>();
            List<Integer> ass2 = new ArrayList<>();
            tp = 1;
    		tp2 = 0;
            for(int j=0; j<N; j++) {
                if((i & (1<<j))>0 ) {
                    asin.add(sin[j]);
                    ass2.add(ss[j]);
                }
            }
            
            if(asin.isEmpty()) continue;
            
            for (int j = 0; j < ass2.size(); j++) {
            	tp *= (asin.get(j));
				tp2 += (ass2.get(j));
			}
            
            result = Math.min(result, Math.abs(tp-tp2));
        }
    }
}