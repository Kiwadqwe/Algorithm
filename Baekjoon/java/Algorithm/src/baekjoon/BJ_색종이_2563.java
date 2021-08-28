package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_색종이_2563 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		boolean[][] visited = new boolean[101][101];
		int result = 0;
		for (int k = 0; k< N; k++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i< x+10; i++) {
				for (int j = y; j < y+10; j++) {
					if(!visited[i][j]) {
						visited[i][j] = true;
						result += 1;
					}
				}
			}
		}
		sb.append(result);
		System.out.println(sb);
	}
}