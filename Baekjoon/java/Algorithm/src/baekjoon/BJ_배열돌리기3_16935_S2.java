package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_배열돌리기3_16935_S2 {
	static int N,M,R,T,tp;
	static int[][] array,temp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < R; i++) {
			T = Integer.parseInt(st.nextToken());
			cal(T);
			array = temp;
			N = array.length;
			M = array[0].length;
		}
		print();
	}
	
	private static void print() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			
			System.out.println();
		}
	}
	
	private static void cal(int d) {
		if(d == 1) {
			temp = new int[N][M];
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M; j++) {	
					temp[N-i-1][j] = array[i][j];
					temp[i][j] = array[N-i-1][j];
				}
			}
		}else if(d == 2) {
			temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					temp[i][M-j-1] = array[i][j];
					temp[i][j] = array[i][M-j-1];
				}
			}
		}else if(d == 3) {
			temp = new int[M][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[j][N-1-i] = array[i][j];
				}
			}
		}else if(d == 4) {
			temp = new int[M][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[M-j-1][i] = array[i][j];
				}
			}
		}else if(d == 5) {
			temp = new int[N][M];
			//1->2
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					temp[i][j+M/2] = array[i][j]; 
				} 
			}
			//2->3
			for (int i = 0; i < N/2; i++) {
				for (int j = M/2; j < M; j++) {
					temp[N/2+i][j] = array[i][j];
				}
			}
			//3->4
			for (int i = N/2; i < N; i++) {
				for (int j = M/2; j < M; j++) {
					temp[i][j-M/2] = array[i][j];
				}
			}
			//4->1
			for (int i = N/2; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					temp[i-N/2][j] = array[i][j];
				}
			}
		}else if(d == 6) {
			temp = new int[N][M];
			//1->4
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					temp[i+N/2][j] = array[i][j]; 
				} 
			}
			//2->1
			for (int i = 0; i < N/2; i++) {
				for (int j = M/2; j < M; j++) {
					temp[i][j-M/2] = array[i][j];
				}
			}
			//3->2
			for (int i = N/2; i < N; i++) {
				for (int j = M/2; j < M; j++) {
					temp[i-N/2][j] = array[i][j];
				}
			}
			//4->3
			for (int i = N/2; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					temp[i][j+M/2] = array[i][j];
				}
			}
		}
	}	
}