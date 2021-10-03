package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_톱니바퀴_14891_G5 {
	static int K,left,right;
	static List<Integer>[] array;
	static int[][] rot;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		array = new ArrayList[4];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			array[i] = new ArrayList<Integer>();
			for (int j = 0; j < 8; j++) {
				array[i].add(s.charAt(j)-'0');
			}
		}

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		rot = new int[K][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				rot[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go();
		
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if(array[i].get(0) == 1) {
				result += array[i].get(0) * Math.pow(2, i);
			}
		}
		
		sb.append(result);
		
		System.out.println(sb);
	}


	private static void go() {
		for (int k = 0; k < rot.length; k++) {
			for (int i = rot[k][0]-1; i > 0; i--) {
				if(array[i].get(6) != array[i-1].get(2)){
					left = i-1;
				}else {
					left = i;
					break;
				}
			}
			
			for (int i = rot[k][0]-1; i < 3; i++) {
				if(array[i].get(2) != array[i+1].get(6)){
					right = i+1;
				}else {
					right = i;
					break;
				}
			}
			
			// 시계
			if(rot[k][1] == 1) {
				Collections.rotate(array[rot[k][0]-1],1);
				int d = -1;
				for (int i = rot[k][0]-2; i >= left; i--) {
					Collections.rotate(array[i],d);
					d *= -1;
				}

				d = -1;
				for (int i = rot[k][0]; i <= right; i++) {
					Collections.rotate(array[i],d);
					d *= -1;
				}
				
			// 반시계
			}else if(rot[k][1] == -1) {
				Collections.rotate(array[rot[k][0]-1],-1);
				int d = 1;
				for (int i = rot[k][0]-2; i >= left; i--) {
					Collections.rotate(array[i],d);
					d *= -1;
				}
				d = 1;
				for (int i = rot[k][0]; i <= right; i++) {
					Collections.rotate(array[i],d);
					d *= -1;
				}
			}
		}
	}
}