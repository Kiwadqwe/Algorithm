package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_문제추천시스템Version2_21944_G3 {
	static int N,M,P,L,G,X;
	
	public static class Point implements Comparable<Point>{
		int num,level,group;
		
		public Point(int num) {
			this.num = num;
		}
		
		public Point(int num, int level, int group) {
			this.num = num;
			this.level = level;
			this.group = group;
		}
		
		@Override
		public int compareTo(Point o) {
			if(this.level - o.level == 0) {
				return num -o.num;
			}else {
				return level -o.level;
			}
		}

		@Override
		public String toString() {
			return "Point [num=" + num + ", level=" + level + ", group=" + group + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		TreeSet<Point> ts = new TreeSet<>();
		Map<Integer, TreeSet<Point>> ts2 = new HashMap<>();
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			
			ts.add(new Point(P,L,G));
			
			if(ts2.containsKey(G)) {
				TreeSet<Point> tp = ts2.get(G);
				tp.add(new Point(P,L,G));
				ts2.replace(G,tp);
			}else {
				TreeSet<Point> tp = new TreeSet<>();
				tp.add(new Point(P,L,G));
				ts2.put(G,tp);
			}
			map.put(P,L);
			map2.put(P,G);
		}
		
		System.out.println(ts2);
//		System.out.println(ts);
//		System.out.println(map);
//		System.out.println(map2);
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		String s = "";
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			if("add".equals(s)) {
				P = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());
				G = Integer.parseInt(st.nextToken());
				ts.add(new Point(P,L,G));
				if(ts2.containsKey(G)) {
					TreeSet<Point> tp = ts2.get(G);
					tp.add(new Point(P,L,G));
					ts2.replace(G,tp);
				}else {
					TreeSet<Point> tp = new TreeSet<>();
					tp.add(new Point(P,L,G));
					ts2.put(G,tp);
				}
				map.put(P,L);
				map2.put(P,G);
			} else if("solved".equals(s)) {
				P = Integer.parseInt(st.nextToken());
				ts.remove(new Point(P,map.get(P),map2.get(P)));
			} else if("recommend".equals(s)) {
				G = Integer.parseInt(st.nextToken());
				X = Integer.parseInt(st.nextToken());
				if(X == 1) {
					// 분류가 G인것 중에서 가장 어려운 문제 번호
					sb.append(ts2.get(G).last().num).append("\n");
				}else {
					// 분류가 G인것 중에서 가장 쉬운 문제 번호 
					//1
					System.out.println(ts2);
					sb.append(ts2.get(G).first().num).append("\n");
				}
			} else if("recommend2".equals(s)) {
				X = Integer.parseInt(st.nextToken());
				if(X == 1) {
					// 분류 상관없이 가장 어려운 문제 번호
					sb.append(ts.last().num).append("\n");
					// 분류 상관없이 가장 쉬운 문제 번호
				}else {
					sb.append(ts.first().num).append("\n");
				}
			} else if("recommend3".equals(s)) {
				X = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());
				if(X == 1) {
					// 분류 상관없이 난이도 L보다 크거나 같은 문제 중 가장 쉬운 문제 번호
					// 조건을 만족하는게 여러개 라면 가장 문제번호가 작은 것
					// 없다면 -1 출력
//					System.out.println(L+" "+ts.ceiling(new Point(0,L,0)));
					sb.append(ts.ceiling(new Point(0,L,0)).num).append("\n");
				}else {
					// 분류 상관없이 난이도 L보다 작은 문제 중 가장 어려운 문제 번호
					// 조건을 만족하는게 여러개 라면 가장 문제번호가 큰 것
					// 없다면 -1 출력
					sb.append(ts.floor(new Point(0,L,0)).num).append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
	}

}
