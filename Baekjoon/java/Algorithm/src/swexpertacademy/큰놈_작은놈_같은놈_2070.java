package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큰놈_작은놈_같은놈_2070 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int a = 0;
		int b = 0;
		
		for(int i = 0; i<tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (a<b) {
				sb.append("#"+(i+1)+" "+"<"+"\n");
			}
			else if(a>b) {
				sb.append("#"+(i+1)+" "+">"+"\n");
			}
			else {
				sb.append("#"+(i+1)+" "+"="+"\n");
			}
		}
		System.out.println(sb);
	}
}