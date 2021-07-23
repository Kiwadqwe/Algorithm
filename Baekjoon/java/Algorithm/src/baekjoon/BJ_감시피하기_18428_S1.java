package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_감시피하기_18428_S1 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static char[][] map;
	static ArrayList<Point> tr;
	static boolean result;

	public static class Point {
		int x, y;

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new char[n][n];
		tr = new ArrayList<>();
		ArrayList<Point> sd = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'T') {
					tr.add(new Point(i, j));
				} else if (map[i][j] == 'X') {
					sd.add(new Point(i, j));
				}
			}
		}
		boolean[] visit = new boolean[sd.size()];
		combination(sd, visit, 0, 3);
		if (result) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

	private static boolean move() {
		for (int k = 0; k < tr.size(); k++) {
			for (int i = 0; i < 4; i++) {
				int a = tr.get(k).x;
				int b = tr.get(k).y;
				while(true) {
					int nx = dx[i]+a;
					int ny = dy[i]+b;
					if(0<=nx && nx<n && 0<=ny && ny<n) {
						if(map[nx][ny] == 'S') {
							return false;
						}
						else if(map[nx][ny] == 'O') {
							break;
						}
						a = nx;
						b = ny;
					}
					else {
						break;
					}
				}
			}
		}
		return true;
	}
	
	static void combination(ArrayList<Point> array, boolean[] visit, int start, int r) {
		if (r == 0) {
//			print(array,visit);
			for (int i = 0; i < array.size(); i++) {
				if (visit[i]) {
					map[array.get(i).x][array.get(i).y] = 'O';
				}
			}
			if(move()) {
				result = true;
			}
			for (int i = 0; i < array.size(); i++) {
				if (visit[i]) {
					map[array.get(i).x][array.get(i).y] = 'X';
				}
			}
			return;
		}
		for (int i = start; i < array.size(); i++) {
			visit[i] = true;
			combination(array, visit, i + 1, r - 1);
			visit[i] = false;
		}
	}

	static void print(ArrayList<Point> array, boolean[] visit) {
		for (int i = 0; i < array.size(); i++) {
			if (visit[i]) {
				System.out.print(array.get(i) + " ");
			}
		}
		System.out.println();
	}
}
