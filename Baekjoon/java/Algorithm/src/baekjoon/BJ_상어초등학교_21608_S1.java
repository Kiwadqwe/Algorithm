package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_상어초등학교_21608_S1 {
	static int N,result;
	static int[][] array,arr;
	static int[] likes;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Point {
		int x,y,cnt,bin;
		
		public Point(int x, int y,int cnt, int bin) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.bin = bin;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		array = new int[N][N];
		likes = new int[4];
		arr = new int[N*N+1][4];
		
		int student = 0;
		
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			student = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				likes[j] = Integer.parseInt(st.nextToken());
				arr[student][j] = likes[j];
			}
			
			batch(student);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		
		// 만족도
		int cnt = 0;
				
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if(0<=nx && nx< N && 0<=ny && ny<N) {
						for (int l = 0; l < 4; l++) {
							if(array[nx][ny] == arr[array[i][j]][l]) {
								cnt+=1;
								break;
							}
						}
					}
				}
				
				if(cnt == 1) {
					result += 1;
				}else if(cnt == 2) {
					result += 10;
				}else if(cnt == 3) {
					result += 100;
				}else if(cnt == 4) {
					result += 1000;
				}
				
				cnt = 0;
			}
		}
		
		System.out.println(result);
	}

	private static void batch(int sd) {
		int rx = 0, ry = 0;
		int rcnt = 0, rbin = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0, bin = 0;
				// 이미 배정 받았다면
				if(array[i][j] != 0) continue;
				
				for (int d = 0; d < 4; d++) {
					int nx = i+dx[d];
					int ny = j+dy[d];
					
					if(0<=nx && nx<N && 0<=ny && ny <N) {
						for (int k = 0; k < likes.length; k++) {
							if(array[nx][ny] == 0) {
								bin+=1;
							}else if(array[nx][ny] == likes[k]){
								cnt+=1;
							}
						}
					}
				}
				
				if(rcnt <= cnt) {
					if(rcnt == cnt) {
						if(rbin<=bin) {
							rx = i;
							ry = j;
							rcnt = cnt;
							rbin = bin;
							}
						}else {
							rx = i;
							ry = j;
							rcnt = cnt;
							rbin = bin;
						}
				}
			}
		}
		// 학생 자리 배치
		array[rx][ry] = sd;
	}
}