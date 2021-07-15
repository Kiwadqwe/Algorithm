package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홀수만더하기_2072 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int num = 0;
		
		for(int i = 0; i<tc; i++) {
			int result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<10; j++) {
				num = Integer.parseInt(st.nextToken());
				if (num%2 ==1) {
					result += num;
					}
				}
			sb.append("#"+(i+1)+" "+result+"\n");
			}
		System.out.println(sb);
		}
	}