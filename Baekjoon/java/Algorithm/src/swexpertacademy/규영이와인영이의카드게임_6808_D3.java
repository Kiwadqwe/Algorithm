package swexpertacademy;

import java.io.*;
import java.util.*;

public class 규영이와인영이의카드게임_6808_D3 {
	static int TC,ghap,ihap,guw,inw,temp;
	static int[] gy,iy,tp;
	static boolean[] card;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			card = new boolean[19];
			gy = new int[9];
			iy = new int[9];
			tp = new int[9];
			st = new StringTokenizer(br.readLine()," ");
			guw = 0;
			inw = 0;
			
			for (int k = 0; k < 9; k++) {
				gy[k] = Integer.parseInt(st.nextToken());
				// 규영이가 선택한 카드는 인영이가 사용 못하도록
				card[gy[k]] = true;
			}
			int idx = 0; 
			for (int i = 1; i <= 18; i++) {
				// 규영이가 선택한 카드 제외하고 카드 넣기
				if(!card[i]) {
					tp[idx] = i;
					idx += 1;
				}
			}
			permutation(0,0);
			sb.append("#"+t+" "+guw+" "+inw+"\n");
		}
		System.out.println(sb);
	}

	private static void check() {
		ghap = 0;
		ihap = 0;
		for (int i = 0; i < 9; i++) {
			// 무승부는 배제
			if(gy[i] > iy[i]) {
				ghap += gy[i]+iy[i];
			}else if(gy[i] < iy[i]) {
				ihap += gy[i]+iy[i];
			}
		}
		if(ghap > ihap) guw+=1;
		else if(ghap < ihap) inw+=1;
	}

	private static void permutation(int cnt, int flag) {
		if(cnt == 9) {
			check();
			return;
		}
		for (int i = 0; i < 9; i++) {
			if((flag & 1<<i) != 0) continue;
			iy[cnt] = tp[i];
			permutation(cnt+1 , flag | 1<<i);
		}
	}
}