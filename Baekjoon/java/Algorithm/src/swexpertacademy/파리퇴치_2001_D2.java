package swexpertacademy;

import java.io.*;
import java.util.*;

public class 파리퇴치_2001_D2 {
	static int TC,N,M;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <=TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int temp = 0;
			int result = 0;
			for (int i = 0; i <=N-M; i++) {
//				if(i+M >N) break;
				for (int j = 0; j <=N-M; j++) {
//					if(j+M >N) break;
					// i+M-1은 [-1][]
					for (int x = i; x < i+M; x++) {
						for (int y = j; y < j+M; y++) {
							temp += map[x][y];
						}
					}
					result = Math.max(result, temp);
					temp = 0;
				}
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb);
	}
}