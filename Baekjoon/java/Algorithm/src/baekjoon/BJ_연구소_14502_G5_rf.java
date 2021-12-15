package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_연구소_14502_G5_rf {
	static int N,M,wall_cnt,virus_cnt,virus_tp,result;
	static int[][] array,tp;
	static List<Point> safe_area;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Point[] list = new Point[3];
	
	public static class Point {
		int x,y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		tp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		safe_area = new ArrayList<Point>();
		// 조합 돌리기 위해서 안전영역 따로 빼기
		// 기존의 벽이랑 바이러스 개수 저장 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(array[i][j] == 0) {
					// 모든 안전영역 넣고 조합 돌리자
					safe_area.add(new Point(i,j));
				}else if(array[i][j] == 1) {
					wall_cnt += 1;
				}else if(array[i][j] == 2) {
					virus_tp += 1;
				}
			}
		}
		
		comb(0,0);
		System.out.println(result);
	}
	
	// 바이러스 퍼트리기
	private static void bfs(boolean[][] visited, Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(point);
		visited[point.x][point.y] = true;
		tp[point.x][point.y] = 2;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(!visited[nx][ny]) {
						// 현재 바이러스를 퍼트릴 수 있는 좌표
						if(tp[nx][ny] == 0) {
							tp[nx][ny] = 2;
							virus_cnt += 1;
							visited[nx][ny] = true;
							q.add(new Point(nx,ny));
						}
					}
				}
			}
		}
	}

	private static void comb(int idx, int start) {
		// 3개씩 만들었으면
		if(idx == 3) {
			// 입력받은 상태의 맵 초기화를 위해서 copy 해줌
			for (int i = 0; i < N; i++) {
				System.arraycopy(array[i], 0, tp[i], 0, tp[i].length);
			}
			
			// 복사한 맵에 바이러스 좌표 넣기
			for(Point p: list) {
				tp[p.x][p.y] = 1;
			}
			
			virus_cnt = 0;
			virus_search();
			
			result = Math.max(result, N*M-virus_cnt-wall_cnt-virus_tp-3);
			return;
		}
		
		// 안전영역의 인덱스 좌표 3개씩 list에 넣기
		for (int i = 0; i < safe_area.size(); i++) {
			list[idx] = safe_area.get(i);
			comb(idx+1,i+1);
		}
	}
	// 바이러스 찾기
	private static void virus_search() {
		boolean visited[][] = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					if(tp[i][j] == 2) {
						bfs(visited, new Point(i,j));
					}
				}
			}
		}
	}
}