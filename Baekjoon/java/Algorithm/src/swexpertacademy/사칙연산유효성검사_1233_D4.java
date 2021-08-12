package swexpertacademy;

import java.io.*;
import java.util.*;

public class 사칙연산유효성검사_1233_D4 {
	static int N, lastIndex;
	static String[] tree;
	static boolean[] visited;
	static int answer;
	static String oper = "+-*/";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			tree = new String[N+1];
			visited = new boolean[N+1];
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				String s = st.nextToken();
				try {
					tree[n+1] =  st.nextToken();
					tree[n+2] = st.nextToken();
				}catch(Exception e){
				}finally {
					tree[n] = s;
				}
			}
			answer = 1;
			solveByPostOrder(1);
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	static void solveByPostOrder(int i) {
		if (i > N) {
			return;
		}
		
		if(answer==0) {
			return;
		}
		solveByPostOrder(i * 2);
		
		if(answer==0) {
			return;
		}
		
		solveByPostOrder(i * 2 + 1);
		
		if(answer==0) {
			return;
		}
		
//		System.out.println("나는 - " + i + " : " + tree[i]);
		String node = tree[i];
		if(oper.contains(node)) {
			if(i *2 > N || i*2+1 >N) {
				answer = 0;
				return;
			}
			else {
				String left = tree[i*2];
				String right = tree[i*2+1];
				if(oper.contains(left) || oper.contains(right)) {
					answer = 0;
					return;
				}
				tree[i] = "0";
			}
		}
		else {
			if(i*2<=N) {
				answer = 0;
				return;
			}
		}
	}
}