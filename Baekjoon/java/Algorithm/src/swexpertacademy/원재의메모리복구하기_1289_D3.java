package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 원재의메모리복구하기_1289_D3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			char[] ch = new char[s.length()];
			for (int i = 0; i < s.length(); i++) {
				ch[i] = s.charAt(i);
			}
			int cnt = ch[0]-'0';
			System.out.println(cnt);
			for (int i = 1; i < s.length(); i++) {
				if(ch[i] != ch[i-1]) {
					cnt += 1;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}