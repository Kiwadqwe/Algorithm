package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_빵집_3109_G2 {
	static int R,C,cnt;
	static char[][] array;
	// 방향 순서로는 오른쪽 위,오른쪽, 오른쪽 아래로 가야됨
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 쓸대 없는 배열이 되므로 열은 뺌
		array = new char[R][];
		for (int i = 0; i < R; i++) {
			array[i] = br.readLine().toCharArray();
		}
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			go(i,0);
//				print();
		}
		System.out.println(cnt);
	}

	private static boolean go(int x, int y) {
		if(y == C-1) {
			cnt += 1;
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			// 1. 도착할때 맨위부터 들어가야됨
			// 2. 가다가 막힌 경우에는 왔던 길을 다시 리셋 해주면서 가지치기 해줘야함
			// 3. 끝에 도착하면 return 함
			if(0<=nx && nx<R && 0<=ny && ny<C) {
				if(!visited[nx][ny]) {
					if(array[nx][ny] != 'x') {
						visited[nx][ny] = true;
						if(go(nx,ny)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}