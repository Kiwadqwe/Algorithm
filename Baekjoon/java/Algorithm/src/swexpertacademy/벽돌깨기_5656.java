package swexpertacademy;

import java.io.*;
import java.util.*;

public class 벽돌깨기_5656 {
	static int N,W,H,result;
	static int[][] array;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Point {
		int x,y,cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
	
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			array = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MAX_VALUE;
			go(0,array);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void go(int idx, int[][] array) {
		if(idx == N) {
			// 남은 벽돌의 개수
			int min = getMain(array);
			result = Math.min(result, min);
			return;
		}
		
		int[][] carray = new int[H][W];
		// 열 선택
		for (int c = 0; c < W; c++) {
			// 열에서 처음 만나는 벽돌 찾기
			int r = 0;
			while(r<H && array[r][c] == 0) r++;
			
			// 열에 벽돌이 없다면
			if(r == H) {
				// 다음 열에서 구슬 던지기
				go(idx+1,array);
			// 열에 벽돌이 있다면
			}else {
				// 구슬을 던지기 전에 copy 진행
				copy(array,carray);
				// 맞은 벽돌 및 주변 벽돌 함께 제거 처리(연쇄적 처리)
				bfs(carray, r,c);
				// 제거된 벽돌들 내리기
				down(carray);
				// 다음 구슬 던지기
				go(idx+1, carray); 
			}
		}
	}

	private static void copy(int[][] array, int[][] carray) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				carray[i][j] = array[i][j];
			}
		}
	}

	private static void down(int[][] array) {
		List<Integer> list = new ArrayList<>();
		for (int c = 0; c < W; c++) {
			int r;
			for (r = H-1; r >= 0; r--) {
				if(0 < array[r][c]) {
					// 밑에서부터 넣음
					list.add(array[r][c]);
					array[r][c] = 0;
				}
			}
			
			// 리스트에 있는 벽돌을 아래쪽부터 넣기
			r = H;
			for (int b : list) {
				r-=1;
				array[r][c] = b;
			}
			
			list.clear();
		}
	}

	private static int getMain(int[][] array) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				// 벽돌이 개수 구하기
				if(0 < array[i][j]) cnt += 1;
			}
		}
		return cnt;
	}

	private static void bfs(int[][] array, int x, int y) {
		Queue<Point> q = new LinkedList<>();
		// 벽돌의 숫자가 1일 경우에 양옆의 벽돌을 부시러 가자
		if(0 < array[x][y]) {
			q.add(new Point(x,y,array[x][y]));
		} 
		
		array[x][y] = 0;
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x;
				int ny = p.y;
				// 한줄 씩 처리
				for (int k = 1; k < p.cnt; k++) {
					nx += dx[i];
					ny += dy[i];
					if(0<=nx && nx<H && 0<=ny && ny<W
							&& array[nx][ny] != 0) {
						if(1 < array[nx][ny]) {
							q.add(new Point(nx,ny,array[nx][ny]));
						}
						// 처리한 벽돌 0으로
						array[nx][ny] = 0;
					}
				}
			}
		}
	}
}