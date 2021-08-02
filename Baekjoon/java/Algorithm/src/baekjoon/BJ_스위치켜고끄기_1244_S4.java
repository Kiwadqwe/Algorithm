package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_스위치켜고끄기_1244_S4 {
	static int[] array;
	static int[][] student;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());;
		
		int n  = Integer.parseInt(st.nextToken());
		array = new int[n+1];
		array[0] = -1;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int s = Integer.parseInt(br.readLine());
		student = new int[s][2];
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				student[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < s; i++) {
			if(student[i][0] == 1) {
				// 남학생
				for (int k = student[i][1]; k < n+1; k++) {
					if(k%student[i][1] == 0) {
						array[k] ^= 1;
					}
				}
			}else if(student[i][0] == 2) {
				int x = student[i][1];
				int y = student[i][1];
				array[student[i][1]] ^= 1;
				
				while(true) {
					x -= 1;
					y += 1;
					if (0 < x && y<=n){
						if(array[x] == array[y]){
							array[x] ^= 1;
							array[y] ^= 1;
						}else {
							break;
						}
					}else {
						break;
					}
				}
			}
		}
		for (int i = 1; i < n+1; i++) {
			System.out.print(array[i]+" ");

			if(i%20 == 0) {
				System.out.println();
			}
		}
	}
}