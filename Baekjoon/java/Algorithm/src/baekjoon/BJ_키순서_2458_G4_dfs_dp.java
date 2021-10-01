package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_키순서_2458_G4_dfs_dp {
	static int N,M,cnt;
	static int[][] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][N+1];
		
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			array[from][to] = 1;
		}
		
		// 탐색확인을 위해서 탐색을 하기전에는 -1 로 초기화
		for (int i = 1; i <= N; i++) {
			array[i][0] = -1;
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			cnt = 0;
			// 자신보다 큰 학생 탐색(아직 탐색이 안된 학생만)
			if(array[i][0] == -1) dfs(i);
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				array[0][j] += array[i][j];
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(array[i][0] + array[0][i] == N-1) ++result;
		}
		
		System.out.println(result);
	}

	private static void dfs(int cur) {
		for (int i = 1; i <= N; i++) {
			// 자신보다 큰 학생
			if(array[cur][i] == 1) {
				// 탐색전인 상황
				if(array[i][0] == -1) {
					// 탐색 하러 감
					dfs(i);
				}
				// 자신보다 큰 학생을 탐색을 완료한 상태(메모가 되어있으면 탐색안하고 바로 내려옴)
				// i보다 큰 학생이 존재
				if(array[i][0] > 0) {
					// i의 인접행렬의 상태를 cur에 반영
					for (int j = 1; j <= N; j++) {
						// i가 j보다 크다 , j는 현재 나보다 크다
						if(array[i][j] == 1) array[cur][j] = 1;
					}
				}
			}
		}
		
		//메모
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			// 0,1 상태로 되어있으니깐 그냥 더해두됨
			cnt += array[cur][i];
		}
		
		// 자신보다 큰 학생의 수를 저장
		array[cur][0] = cnt;
	}
}