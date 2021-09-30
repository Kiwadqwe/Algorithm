package swexpertacademy;

import java.io.*;
import java.util.*;

public class 보급로_1249 {
	static int TC,N;
	static final int INF = (int) 1e9;
	static int[][] array;
	static int[][] d;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static PriorityQueue<Point> pq;
	
	public static class Point implements Comparable<Point>{
		int x,y,dis;
		
		public Point(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			if(this.dis < o.dis) {
				return -1;
			}
			return 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		
		TC = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			
			array = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					array[i][j] = s.charAt(j) -'0';
				}
			}

			// 최단 거리 테이블 무한으로 초기화
			d = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(d[i], INF);
			}
			
			dijkstra();
			
			sb.append("#").append(t).append(" ").append(d[N-1][N-1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dijkstra() {
		int x = 0, y = 0;
		
		pq = new PriorityQueue<>();
		pq.add(new Point(x,y, array[x][y]));
		d[x][y] = array[x][y];
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			int dist = p.dis;
			
			// 현재 노드가 이미 처리된 적 있으면 
			if(d[p.x][p.y] < dist) continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<N){
					int cost = dist+array[nx][ny];
					
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