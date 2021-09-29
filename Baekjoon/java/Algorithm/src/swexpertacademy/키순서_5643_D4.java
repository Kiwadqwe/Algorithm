package swexpertacademy;

import java.io.*;
import java.util.*;

public class 키순서_5643_D4 {
	static int TC,N,M,a,b,cnt,result;
	static boolean[] visited;
	static int[][] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			
			array = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				array[a][b] = 1;
			}
			
			result = 0;
			for (int i = 1; i <= N; i++) {
				bfs(i);
				if(cnt == N-1) result += 1;
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs(int k) {
		Queue<Integer> q = new LinkedList<Integer>();

		visited = new boolean[N+1];
		q.add(k);
		visited[k] = true;
		cnt = 0;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) {
					if(array[x][i] == 1) {
						visited[i] = true;
						cnt += 1;
						q.add(i);
					}
				}
			}
		}
		
		Queue<Integer> q2 = new LinkedList<Integer>();
		q2.add(k);
		visited = new boolean[N+1];
		visited[k] = true;
		
		while(!q2.isEmpty()) {
			int x = q2.poll();
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) {
					if(array[i][x] == 1) {
						visited[i] = true;
						cnt += 1;
						q2.add(i);
					}
				}
			}
		}
	}
}