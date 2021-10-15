package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_낚시왕_17143_G2 {
	static int R, C, M;
	static Shark[][] array, temp, swap;

	static class Shark {
		int r, c, s, d, z;
		// 이동 방향에 따른 증분
		int delta;
		boolean isHor;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			// 가로 또는 세로??
			this.isHor = this.d > 2;
			// 방향에 따른 증분 Up=1, Dn=2, Ri=3, Le=4
			this.delta = (d == 1 || d == 4) ? -1 : 1;
			// 방향에 따라 순환한다.!!! --> 순환하는 거리는 날려버려야!!!
			if (isHor) {
				this.s = this.s % ((C - 1) * 2);
			} else {
				this.s = this.s % ((R - 1) * 2);
			}
		}

		public void move() {
			if (isHor) {
				for (int i = 0; i < s; i++) {
					c += delta;
					if (c == 0) {
						c = 2;
						delta *= -1;
					} else if (c == C + 1) {
						c = C - 1;
						delta *= -1;
					}
				}
			} else {
				for (int i = 0; i < s; i++) {
					r += delta;
					if (r == 0) {
						r = 2;
						delta *= -1;
					} else if (r == R + 1) {
						r = R - 1;
						delta *= -1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		array = new Shark[R + 1][C + 1];
		temp = new Shark[R+1][C+1];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			Shark shark = new Shark(r, c, s, d, z);
			array[r][c] = shark;
		}
		
		int result = 0;
		for(int c=1; c<=C; c++) {
			// 가장 가까운 고기 잡기 
			for(int r=1; r<=R; r++) {
				if(array[r][c]!=null) {
					result+=array[r][c].z;
					array[r][c] = null;
					break;
				}
			}
			
			// 상어들이 동시에 이동한다..
			for(int r=1; r<=R; r++) {
				for(int c2=1; c2<=C; c2++) {
					Shark shark = array[r][c2];
					if(shark!=null) {
						// 지도에서는 상어 지워버리기.
						array[r][c2] = null;
						shark.move();
						// 상어를 임시 맵에 배치한다.
						Shark pre = temp[shark.r][shark.c];
						if(pre==null) {
							temp[shark.r][shark.c] = shark;
						}else if(pre.z < shark.z) {
							temp[shark.r][shark.c] = shark;
						}
					}
				}
			}// 모든 상어 이동 완료!!!
			
			swap = array;
			array = temp;
			temp = swap;
			
		}

		System.out.println(result);
	}
}