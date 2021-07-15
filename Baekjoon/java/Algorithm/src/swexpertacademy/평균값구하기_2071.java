package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균값구하기_2071 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int num = 0;
		
		for(int i = 0; i<tc; i++) {
			double result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<10; j++) {
				num = Integer.parseInt(st.nextToken());
				result += num;
			}
			sb.append("#"+(i+1)+" "+Math.round(result/10)+"\n");
		}
		System.out.println(sb);
	}
}