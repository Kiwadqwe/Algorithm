package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_20056_마법사상어와파이어볼_G5 {
	static int N,M,K;
	static boolean[][] visited;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static ArrayList<Point> arr,temp;
	static List<Point>[][] array;
	
	public static class Point{
		int r,c,m,s,d;

		public Point(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		
		array = new ArrayList[N][N];
		// array 에 있는거 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				array[i][j] = new ArrayList<Point>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			arr.add(new Point(r,c,m,s,d));
		}
		
		for (int i = 0; i < K; i++) {
			go();
			check();
		}
		
		// 결과
		int result = 0;
		for (int i = 0; i < arr.size(); i++) {
			result += arr.get(i).m;
		}
		
		System.out.println(result);
	}

	private static void check() {
		boolean[][] visited = new boolean[N][N];
		arr.clear();
		
		for (int i = 0; i < temp.size(); i++) {
			int nx = temp.get(i).r;
			int ny = temp.get(i).c;
			
			// 이미 처리한거면
			if(visited[nx][ny]) {
				continue;
			}
			int size =  array[nx][ny].size();
			int hm = 0, hs = 0;
			int hol = 0, jja = 0;
			
			// 겹친거
			if(2 <= size) {
				visited[nx][ny] = true;
				
				for (int j = 0; j < size; j++) {
					hm += array[nx][ny].get(j).m;
					hs += array[nx][ny].get(j).s;
					if(array[nx][ny].get(j).d % 2 == 0) {
						jja+=1;
					}else {
						hol+=1;
					}
				}
				
				int nm =  hm / 5;
				int ns =  hs / size;
				
				if(jja == size || hol == size) {
					for (int j = 0; j <= 6; j+=2) {
						arr.add(new Point(nx,ny,nm,ns,j));
					}
				}else {
					for (int j = 1; j <= 7; j+=2) {
						arr.add(new Point(nx,ny,nm,ns,j));
					}
				}

			}else {
				// 겹치지않고 이동 완료한거 넣기
				arr.add(temp.get(i));
			}
			// 다끝낫으니깐 비워주자~
			array[nx][ny].clear();
		}
		
	}

	private static void go() {
		temp = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			// 범위가 벗어날 경우 
			int nx = ( arr.get(i).r + N + ( dx[arr.get(i).d] * (arr.get(i).s % N) )) %N;
			int ny = ( arr.get(i).c + N + ( dy[arr.get(i).d] * (arr.get(i).s % N) )) %N;
			
			// 질량이 0인 경우는 저장 안함
			if(arr.get(i).m == 0) continue;
			temp.add(new Point(nx,ny,arr.get(i).m,arr.get(i).s,arr.get(i).d));
			array[nx][ny].add(arr.get(i));
		}
	}

}