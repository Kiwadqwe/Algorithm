package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드_1873_D3 {
	static int TC, H, W,ans;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		H= Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		
		int ans = 0;
		int x=0;
		int y=0;
		String b = "";
		int dir = 0;
		
		for(int i=0; i<H; i++) {
			b = br.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = b.charAt(j);
			if (map[i][j] == '<') {
				x=i;
				y=j;
				dir = 1;
			}
			else if (map[i][j] == '>') {
				x=i;
				y=j;
				dir = 2;
			}
			
			else if (map[i][j] == '^') {
				x=i;
				y=j;
				dir = 3;
			}
			else if (map[i][j] == 'v') {
				x=i;
				y=j;
				dir = 4;
			}
		}
	}
		
		int N = Integer.parseInt(br.readLine());
		char[] move = new char[N];

		move = br.readLine().toCharArray();
		char tp = ' ';
		
		for (char c : move) {
			if (c == 'U'){
				if (map[x+1][y] == '.') {
					tp = map[x+1][y];
					map[x+1][y] = map[x][y];
					map[x][y] = tp;
				}
			}
			else if(c == 'D') {
					if (map[x-1][y] == '.') {
						tp = map[x-1][y];
						map[x-1][y] = map[x][y];
						map[x][y] = tp;
				}
			}
			else if(c == 'L') {
					if (map[x][y-1] == '.') {
						tp = map[x][y-1];
						map[x][y-1] = map[x][y];
						map[x][y] = tp;
				}
			}
			else if(c == 'R') {
					if (map[x][y+1] == '.') {
						tp = map[x][y+1];
						map[x][y+1] = map[x][y];
						map[x][y] = tp;
				}
			}
			else if(c =='S') {
					
				}
			}
		
		print();
		System.out.printf("#%d %d",TC,ans);
	}

	private static void print() {
		System.out.println();
		for(int i=0; i<H; i++) {
			for (int j = 0; j<W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
}
