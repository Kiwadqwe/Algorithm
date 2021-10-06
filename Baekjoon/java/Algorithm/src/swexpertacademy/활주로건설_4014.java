package swexpertacademy;

import java.io.*;
import java.util.*;

public class 활주로건설_4014 {
	static int TC,N,X,cnt,result;
	static int[][] row,col;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			row = new int[N][N];
			col = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					int a = Integer.parseInt(st.nextToken());
					row[i][j] = a;
					col[j][i] = a;
				}
			}
			
			int result = 0;
			for (int i = 0; i < N; i++) {
				result += go(row[i]);
				result += go(col[i]);
			}
				
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int go(int[] tp) {
		cnt = 1;
		// 높이는 차이가 1
		for (int i = 1; i < N; i++) {
			// 같으면 평지거나 경사로의 높이가 같음
			if(tp[i] == tp[i-1]) cnt+=1;
			// 현재까지 지나왔던 지형들이  x가 같거나 이상이여야 한다. == (낮은 지형의 높이가 동일하게 경사로의 길이만큼 연속되는 곳에 설치 할 수 있다) 라는 조건을 만족하기 위해
			else if(tp[i] - tp[i-1] == 1 
					&& X <= cnt) cnt = 1;
			// 현재까지 왔던 왼쪽 지형이 다 평지였다면,경사로를 만들어 cnt를 0이상을 만들게 하자
			else if(tp[i-1] - tp[i] == 1
					&& 0 <= cnt) cnt = 1-X;
			else return 0;
		}
		
		if(0 <= cnt) return 1;
		return 0;
	}
}