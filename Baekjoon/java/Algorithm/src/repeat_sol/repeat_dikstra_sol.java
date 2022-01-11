package repeat_sol;

import java.io.*;
import java.util.*;

public class repeat_dikstra_sol {
	static int N,cnt;
	static final int INF = (int) 1e9;
	static int[][] array,d;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static PriorityQueue<Point> pq;
	
	public static class Point implements Comparable<Point> {
		int x,y,dis;
		
		public Point(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		// 비용이 짧은 순으로 높은 우선순위를 가질 수 있도록
		@Override
		public int compareTo(Point o) {
			return this.dis - o.dis;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0) break;
			
			cnt += 1;
			array = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 최단 거리 테이블 무한으로 초기화
			d = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(d[i], INF);
			}
			
			dijkstra();
			
			sb.append("Problem ").append(cnt).append(": ").append(d[N-1][N-1]).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void dijkstra() {
		// 시작 노드로 가기 위한 최단 경로는 0으로 설정하여 큐에 삽입
		pq = new PriorityQueue<>();
		pq.add(new Point(0,0, array[0][0]));
		d[0][0] = array[0][0];
		
		while(!pq.isEmpty()) {
			// 최단 거리가 가장 짧은 노드
			Point p = pq.poll();
			
			// 현재 노드가 이미 처리된 적이 있으면 무시
			if(d[p.x][p.y] < p.dis) continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					int cost = p.dis+array[nx][ny];
					
					// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
					if(cost < d[nx][ny]) {
						d[nx][ny] = cost;
						pq.add(new Point(nx,ny,cost));
					}
				}
			}
		}
	}
}


//3
//5 5 4
//3 9 1
//3 2 7
//5
//3 7 2 0 1
//2 8 0 9 1
//1 2 1 8 1
//9 8 9 2 0
//3 6 5 1 5
//7
//9 0 5 1 1 5 3
//4 1 2 1 6 5 3
//0 7 6 1 6 8 5
//1 1 7 8 3 2 3
//9 4 0 7 6 4 1
//5 8 3 2 4 8 3
//7 4 8 4 8 3 4
//0

//Problem 1: 20
//Problem 2: 19
//Problem 3: 36