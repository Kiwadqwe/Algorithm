package swexpertacademy;

import java.io.*;
import java.util.*;

public class 암호생성기_1225_D3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				int n = Integer.parseInt(st.nextToken());
				q.offer(n);
			}
			boolean check = false;
			while(true) {
				for (int i = 1; i <= 5; i++) {
					int num = q.poll();
					num -= i;
					if(num <= 0) {
						num = 0;
						check = true;
						q.offer(num);
						break;
					}
					q.offer(num);
				}
				if(check) break;
			}
			System.out.print("#"+t+" ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}
}