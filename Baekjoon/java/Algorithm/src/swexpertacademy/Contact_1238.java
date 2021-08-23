package swexpertacademy;

import java.io.*;
import java.util.*;

public class Contact_1238 {
	static int L,start,result;
	static boolean[] visited;
	static List<Point> list;
	static int[] cnt;
	
	public static class Point {
		int x,y;
		
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int r = 1; r <= 10; r++) {				
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			visited = new boolean[101];
			
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L/2; i++) {
				int f = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				list.add(new Point(f,t));
			}
			
			cnt = new int[101];
			
			go();
			
			sb.append("#").append(r).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void go() {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.add(start);
		cnt[start] = 0;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			for (int i = 0; i < list.size(); i++) {
				//방문 안했고 현재 위치가 v인 경우
				if(!visited[list.get(i).y] && list.get(i).x == v) {
					visited[list.get(i).y] = true;
					cnt[list.get(i).y] = cnt[v]+1;
					q.add(list.get(i).y);
				}
			}
		}
		
		int tp = 0;
		for (int i = 0; i < cnt.length; i++) {
			if(tp <= cnt[i]) {
				tp = cnt[i];
				result = i;
			}
		}
	}
}