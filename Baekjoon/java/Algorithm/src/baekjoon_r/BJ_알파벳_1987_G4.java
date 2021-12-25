package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_알파벳_1987_G4 {
	static int R,C,cnt,result;
	static int[][] array;
	static boolean[] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		array = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				array[i][j] = s.charAt(j) - 'A';
			}
		}
		
		visited = new boolean[26];
		visited[array[0][0]] = true;
		
		dfs(0,0,1);
		System.out.println(result);
	}

	private static void dfs(int x, int y, int cnt) {
		result = Math.max(result, cnt);
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || R<=nx || ny<0 || C<=ny) continue;
			
			if(visited[array[nx][ny]]) continue;
			visited[array[nx][ny]] = true;
			dfs(nx,ny,cnt+1);
			visited[array[nx][ny]] = false;
		}
	}

}