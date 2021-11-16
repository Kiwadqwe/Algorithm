package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_체스판다시칠하기_1018_S2 {
	static int N,M,result;
	static char[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if(s.charAt(j) == 'W') {
					array[i][j] = 0;
				}else {
					array[i][j] = 1;
				}
			}
		}
		
		result = Integer.MAX_VALUE;
		
		int answer = 8 * 8;
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				int BW = 0;
				int WB = 0;
	            for (int x = 0; x < 8; x++) {
	                for (int y = 0; y < 8; y++) {
	                    // BW로 시작하는 체스판과의 차이 계산
	                    if ((x + y) % 2 == 0 && array[i + x][j + y] != 1) {
	                        BW += 1;
	                    } else if ((x + y) % 2 == 1 && array[i + x][j + y] != 0) {
	                        BW += 1;
	                    }
	                    // // WB로 시작하는 체스판과의 차이 계산 (BW의 반대값으로 계산)
	                    WB = 64 - BW;
	                }
	            }
	            
	            answer = Math.min(answer, BW);
	            answer = Math.min(answer, WB);
			}
		}
		System.out.println(answer);
	}

}