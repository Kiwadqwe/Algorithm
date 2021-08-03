package swexpertacademy;

import java.io.*;
import java.util.*;

public class Ladder1_1210_D4 {
	static int n =100,tc,x,y,nx,ny,result_x,result_y;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
		
        for (int t = 1; t <= 10; t++) {
        	st = new StringTokenizer(br.readLine());
        	tc = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			
			while(true) {
				nx = dx[0]+x;
				ny = dy[0]+y;
				if(nx == 0) {
					result_x = nx;
					result_y = ny;
					break;
				}
				x = nx;
				y = ny;
				if (0<=nx && nx<n && 0<=ny && ny<n) {
					if(ny+1 <n && map[nx][ny+1] == 1) {
						move(nx,ny,1);
					}else if(0<= ny-1 &&map[nx][ny-1] == 1) {
						move(nx,ny,3);
					}
				}
			}
			System.out.println("#"+tc+" "+result_y);
        }
	}

	private static void move(int nx, int ny, int k) {
		while(true) {
			int nx2 = nx+dx[k];
			int ny2 = ny+dy[k];
			if(map[nx2][ny2] == 1) {
				if (0<=nx2 && nx2<n && 0<=ny2 && ny2<n) {
					nx = nx2;
					ny = ny2;
				}
			}
			
			if (map[nx-1][ny] == 1) {
				x = nx;
				y = ny;
				break;
			}
		}
	}
}