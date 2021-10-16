package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_아기상어_16236_G4 {
	static int N,result,time;
	static int[][] array;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean[][] visited;
	
	public static class Fish implements Comparable<Fish>{
		int x,y,size,dist;
		
		public Fish(int x,int y, int size, int dist) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.dist == o.dist) {
				if(this.x == o.x) {
					// 3순위 정렬 col이 가장 작은 물고기
					return Integer.compare(this.y, o.y);
				}else {
					// 2순위 정렬 row가 작은 녀석
					return Integer.compare(this.x, o.x);
				}
			}else {
				// 1순위 정렬 거리 기준
				return Integer.compare(this.dist, o.dist);
			}
		}
	}
	
	public static class Shark {
		int x, y, size, eatCnt;

		public Shark(int x, int y, int size, int eatCnt) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.eatCnt = eatCnt;
		}

		public void eat() {
			eatCnt += 1;
			if(eatCnt == size) {
				this.size += 1;
				eatCnt = 0;
			}
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", size=" + size + ", eatCnt=" + eatCnt + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		Shark shark = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j] == 9) {
					// 상어 정보 넣기
					shark = new Shark(i,j,2,0);
					array[i][j] = 0;
				}
			}
		}

		bfs(shark);
		System.out.println(result);
	}

	private static void bfs(Shark shark) {
		Queue<Shark> q = new LinkedList<>();
		q.add(shark);
		visited = new boolean[N][N];
		visited[shark.x][shark.y] = true;
		
		int depth = 0;
		Fish target = null;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size --> 0) {
				Shark p = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					
					if(0<=nx && nx<N && 0<=ny && ny<N
							&& !visited[nx][ny]) {
						visited[nx][ny] = true;
						
						// 물고기가 없는 곳
						if(array[nx][ny] == 0 || array[nx][ny] == p.size) {
							q.add(new Shark(nx,ny,p.size,p.eatCnt));
						// 물고기가 있으면서 상어보다 크기가 작은 경우
						}else if(array[nx][ny] < p.size) {
							Fish fish = new Fish(nx, ny, array[nx][ny], depth+1);
							// 현재 지정한 물고기가 없는 경우
							if(target == null) {
								// 물고기 설정
								target = fish;
							}else {
								// 우선순위를 고려해서 물고기 타겟 변경
								target = target.compareTo(fish) < 0 ? target : fish;
							}
						}
					}
				}
			}
			// 현재 타겟 물고기가 없을 경우
			if(target != null) break;
			depth += 1;
		}
		
		// 더이상 먹을 물고기가 없다면 끝내자
		if(target == null) {
			return;
		}else {
			// 물고기 먹기
			shark.eat();
			// 먹은 물고기 0으로
			array[target.x][target.y] = 0;
			// 물고기와의 거리 더하기
			result += target.dist;
			// 새로운 상어 정보 추가 후 bfs 진행
			bfs(new Shark(target.x, target.y, shark.size, shark.eatCnt));
		}
	}
}