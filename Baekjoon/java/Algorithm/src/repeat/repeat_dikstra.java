//package repeat;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class repeat_dikstra {
//	static int N,cnt;
//	static int[] dx = {-1,0,1,0};
//	static int[] dy = {0,1,0,-1};
//	static final int INF = (int) 1e9;
//	static int[][] array,d;
//	static PriorityQueue<Point> pq;
//
//	public static class Point implements Comparable<Point> {
//		int x,y,dis;
//
//		public Point(int x, int y, int dis) {
//			this.x = x;
//			this.y = y;
//			this.dis = dis;
//		}
//
//		@Override
//		public int compareTo(Point o) {
//			return this.dis - o.dis;
//		}
//	}
//
//	// 최단경로를 구하자!
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//		StringBuilder sb = new StringBuilder();
//
//		while(true) {
//			st = new StringTokenizer(br.readLine()," ");
//			N = Integer.parseInt(st.nextToken());
//
//			if(N == 0) break;
//
//			cnt += 1;
//			array = new int[N][N];
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine()," ");
//				for (int j = 0; j < N; j++) {
//					array[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//
//			dikstra();
//			sb.append("Problem ").append(cnt).append(": ").append(d[N-1][N-1]).append("\n");
//		}
//
//		System.out.println(sb);
//	}
//
//
//
//}
//
//
////3
////5 5 4
////3 9 1
////3 2 7
////5
////3 7 2 0 1
////2 8 0 9 1
////1 2 1 8 1
////9 8 9 2 0
////3 6 5 1 5
////7
////9 0 5 1 1 5 3
////4 1 2 1 6 5 3
////0 7 6 1 6 8 5
////1 1 7 8 3 2 3
////9 4 0 7 6 4 1
////5 8 3 2 4 8 3
////7 4 8 4 8 3 4
////0
//
////Problem 1: 20
////Problem 2: 19
////Problem 3: 36