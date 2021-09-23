package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_다리만들기2_17472_G2 {
	static int N,M,result,cnt,V;
	static int[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static PriorityQueue<Edge> edges;	
	static int[] repres;
	
	public static class Point{
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int from, to, cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		V = 2;
		// 정점의 개수 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(array[i][j] == 1 && !visited[i][j]) {
					bfs(new Point(i,j),V);
					V += 1;
				}
			}
		}
		
		edges = new PriorityQueue<>();
		// 섬간의 거리 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(1 < array[i][j]) {
					distance(i,j);
				}
			}
		}
		
		kruskal();
	}

	private static void kruskal() {
		// 1. make
		make();
		
		while(!edges.isEmpty()) {
			// 2. union
			Edge head = edges.poll();
			union(head.from,head.to,head.cost);
		}
		
		// 연결이 안됐을때
		int repre = find(2);
		for (int i = 3; i < repres.length; i++) {
			if(repre != find(repres[i])) {
				result = -1;
				break;
			}
		}
		System.out.println(result);
	}

	private static void union(int from, int to, int cost) {
		from = find(from);
		to = find(to);
		if(from != to) {
			repres[from] = to;
			result += cost;
		}
	}

	private static int find(int from) {
		if(repres[from] == from) {
			return from;
		}else {
			return repres[from] = find(repres[from]);
		}
	}

	private static void make() {
		repres = new int[V];
		
		for (int i = 2; i < repres.length; i++) {
			repres[i] = i;
		}
	}

	private static void distance(int x, int y) {
		// 현재 위치
		int tp = array[x][y];
		
		for (int i = 0; i < 4; i++) {
			for (int l = 1;; l++) {
				// 한방향으로 계속 손뻗어보기
				int nx = x+dx[i] * l;
				int ny = y+dy[i] * l;
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					// 뻗었는데 바다면
					if(array[nx][ny] == 0) continue;
					// 같은 땅이면
					if(array[nx][ny] == tp) break;
					
					// 다른 땅을 만난 경우
					// 다리가 무조건 2이상이여야 하므로
					if(2 < l) {
						// 현재 위치(from), 다른 땅(to), 다리의 길이
						edges.add(new Edge(tp,array[nx][ny],l-1));
					}
					// 다리 만들었으면 나가기
					break;
				// 범위 벗어나면 다른 방향 찾기
				}else {
					break;
				}
			}
		}
	}

	private static void bfs(Point point, int V) {
		Queue<Point> q = new LinkedList<Point>();
		visited[point.x][point.y] = true;
		q.add(point);
		array[point.x][point.y] = V;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(!visited[nx][ny]) {
						if(array[nx][ny] == 1) {
							visited[nx][ny] = true;
							array[nx][ny] = V;
							q.add(new Point(nx,ny));
						}
					}
				}
			}
		}
	}
}