package swexpertacademy;

import java.io.*;
import java.util.*;

public class 상호의배틀필드_1873_D3 {
	static int TC, H, W, x, y, dir;
	static char[][] map;
	static char[] direction = {'^', '>', 'v', '<'};
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			String b = null;
			for (int i = 0; i < H; i++) {
				b = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = b.charAt(j);
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						x = i;
						y = j;
						for (int l = 0; l < 4; l++) {
							if (map[i][j] == direction[l]) dir = l;
						}
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			char[] move = br.readLine().toCharArray();
			
			for (char c : move) {
				if (c == 'U') {
					dir = 0;
					map[x][y] = direction[dir];
					calDir();
				} else if (c == 'D') {
					dir = 2;
					map[x][y] = direction[dir];
					calDir();
				} else if (c == 'L') {
					dir = 3;
					map[x][y] = direction[dir];
					calDir();
				} else if (c == 'R') {
					dir = 1;
					map[x][y] = direction[dir];
					calDir();
				} else if (c == 'S') {
					shoot();
				}
			}
			sb.append("#" + k+" ");
			print();
		}
		System.out.println(sb);
	}

	private static void print() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}

	private static void shoot() {
		int nx = x;
		int ny = y;
		
		while (true) {
			if (check(nx,ny)) {
				if (map[nx][ny] == '*') {
					map[nx][ny] = '.';
					break;
				}
			} else {
				break;
			}
			if (map[nx][ny] == '#') {
				break;
			}
			nx += dx[dir];
			ny += dy[dir];
		}
	}

	private static void calDir() {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(check(nx,ny)) {
			if(map[nx][ny] == '.') {
				map[x][y] = '.';
				map[nx][ny] = direction[dir];
				x = nx;
				y = ny;
			}
		}
	}
	
	public static boolean check(int x, int y ) {
		if(x >= 0 && x < H  && y >= 0 && y < W) return true;
		return false;
	}
}

//1
//3 7
//***....
//*-..#**
//#<.****
//23
//SURSSSSUSLSRSSSURRDSRDS
//
//#1 **....v
//.-..#..
//#......