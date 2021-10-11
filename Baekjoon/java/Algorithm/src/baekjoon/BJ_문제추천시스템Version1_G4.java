package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_문제추천시스템Version1_G4 {
	static int N,M;
	
	public static class Point implements Comparable<Point>{
		int num,level;
		
		public Point(int num, int level) {
			this.num = num;
			this.level = level;
		}

		@Override
		public int compareTo(Point o) {
			if(level - o.level == 0) {
				return num - o.num;
			}else {
				return level - o.level;
			}
		}

		@Override
		public String toString() {
			return "Point [num=" + num + ",level=" + level + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		TreeSet<Point> ts = new TreeSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		int P=0,L=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			ts.add(new Point(P,L));
			map.put(P, L);
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("recommend")) {
				P = Integer.parseInt(st.nextToken());
				if(P == 1) {
					sb.append(ts.last().num).append("\n");
				}else {
					sb.append(ts.first().num).append("\n");
				}
			}else if(s.equals("add")) {
				P = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());
				
				ts.add(new Point(P,L));
				map.put(P, L);
			}else if(s.equals("solved")) {
				P = Integer.parseInt(st.nextToken());
				ts.remove(new Point(P,map.get(P)));
			}
		}
		
		System.out.println(sb);
	}

}
