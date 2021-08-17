package jungol;

import java.io.*;
import java.util.*;

public class 냉장고_1828 {
	static int N,cnt;
	
	public static class Point implements Comparable<Point>{
		int start,end;
		
		public Point(int start, int end){
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Point o) {
			int value = this.end - o.end;
			if(value != 0) return value;
			
			return this.start - o.start;
		}

		@Override
		public String toString() {
			return "Point [start=" + start + ", end=" + end + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		Point[] arr = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);		
		
		for (Point point : go(arr)) {
//			System.out.println(point.toString());
			cnt +=1;
		} 
		System.out.println(cnt);
	}

	private static ArrayList<Point> go(Point[] p) {
		ArrayList<Point> list = new ArrayList<Point>();
		
		Arrays.sort(p);
		list.add(p[0]);
		
		for (int i = 1; i < p.length; i++) {
			if(list.get(list.size()-1).end < p[i].start) {
				list.add(p[i]);
			}
		}
		return list;
	}
}