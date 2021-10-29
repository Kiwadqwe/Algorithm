package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_게리맨더링_17471_G5 {
	static int N,result = Integer.MAX_VALUE;
	static int[] popu;
	static boolean[] visited;
	static LinkedList<Point>[] array;
	
	public static class Point {
		int x,y,cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		
		array = new LinkedList[N];
		popu = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			array[i] = new LinkedList<>();
			popu[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				int a = Integer.parseInt(st.nextToken());
				// 구역별로 연결된 노드 및 인구수 저장
				array[i].add(new Point(i,a-1,popu[i]));
			}
		}
		
		// 홀로 선정될 수 있으니 
		for (int i = 0; i < N; i++) {
			array[i].add(new Point(i,i,popu[i]));
		}
		
		// 부분 집합 진행
		powerset();
		
		if(result == Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(result);
		}
		
	}

	private static void powerset() {
		for (int i = 0; i < (1<<N); i++) {
			LinkedList<Integer> include = new LinkedList<>();
			LinkedList<Integer> exclude = new LinkedList<>();
			
			for (int j = 0; j < N; j++) {
				if((i & (1<<j)) > 0) {
					include.add(j);
				}else {
					exclude.add(j);
				}
			}
			
			if(include.isEmpty()) continue;
			if(exclude.isEmpty()) continue;
			
			int in = bfs(include);
			int ex = bfs(exclude);
			if(in == -1 || ex == -1) continue;
			
			result = Math.min(result,Math.abs(in-ex));
			
		}
	}

	private static int bfs(LinkedList<Integer> point) {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[N];
		visited[point.peek()] = true;
		// 첫번째 선거구의 연결되 있는 모든 지역 넣기
		q.addAll(array[point.peek()]);
		
		int hap = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < point.size(); i++) {
				if(p.y == point.get(i) 
						&& !visited[p.y]){
					visited[p.y] = true;
					q.addAll(array[p.y]);
				}
			}
		}
		
		for (int i = 0; i < point.size(); i++) {
			// 하나라도 연결 안된곳이 있다면
			if(!visited[point.get(i)]) {
				return -1;
			}else {
				// 연결된곳의 인구수 더하기
				hap += array[point.get(i)].peek().cnt;
			}
		}
		
		return hap;
	}
}