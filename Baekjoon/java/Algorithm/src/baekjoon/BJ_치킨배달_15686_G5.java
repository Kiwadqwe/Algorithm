package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_치킨배달_15686_G5 {
	static int N,M,fal;
	static int[][] array;
	static List<Point> chi,house;
	static List<Integer> result;
	public static class Point{
		int x,y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][N];
		chi = new ArrayList<>();
		house = new ArrayList<>(); 
		result = new ArrayList<>(); 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if (array[i][j] == 2) {
					// arrayList에 인덱스 값 넣기
					chi.add(new Point(i,j));
				}else if(array[i][j] == 1) {
					house.add(new Point(i,j));
				}
			}
		}
		
		makeCombination(M,new int[M], new int[M],0);
		int f = Integer.MAX_VALUE;
		for (int i = 0; i < result.size(); i++) {
			f = Math.min(result.get(i), f);
		}
		System.out.println(f);
	}
	
	static void makeCombination(int toChoose, int [] choosed,int [] choosed2, int startIdx) {
	    if(toChoose==0) {
	        for (int i = 0; i < house.size(); i++) {
	        	Point p = house.get(i);
	        	int tp = Integer.MAX_VALUE;
	        	for (int j = 0; j < choosed2.length; j++) {
	        		// 집에서 각각의 치킨집 최소값
	        		tp = Math.min(tp,Math.abs(choosed[j]-p.x)+Math.abs(choosed2[j]-p.y));
	        	}	  
	        	// 각각의 집에서 제일 가까운 치킨 집
	        	fal += tp;
	        }
	    	result.add(fal);
	    	fal = 0;
	        return;
	    }
	    for(int i=startIdx; i<chi.size(); i++) {
	        choosed[choosed.length-toChoose] = chi.get(i).x;
	        choosed2[choosed2.length-toChoose] = chi.get(i).y;
	        makeCombination(toChoose-1, choosed,choosed2, i+1);
	    }
	}	 
}