//package repeat;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class repeat_dfs_bfs {
//	static int N,M,V;
//	static int[][] array;
//	static boolean[] visited;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		V = Integer.parseInt(st.nextToken());
//
//		array = new int[N+1][N+1];
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//
//			array[a][b] = 1;
//			array[b][a] = 1;
//		}
//
//		visited = new boolean[N+1];
//		dfs(V);
//		System.out.println();
//		visited = new boolean[N+1];
//		bfs();
//	}
//
//}
//
////4 5 1
////1 2
////1 3
////1 4
////2 4
////3 4
//
////1 2 4 3
////1 2 3 4