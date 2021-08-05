package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_탑_2493_G5 {
	static int N;
	static int[] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		Stack<int[]> sk = new Stack<>();
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		int num = Integer.parseInt(st.nextToken());
		
		sk.push(new int[] {1,num});
		sb.append("0 ");
		for (int i = 2; i <=N; i++) {
			num = Integer.parseInt(st.nextToken());
			while(true) {
				// 스택이 비었을때 탈출
				if(sk.isEmpty()) break; 
				// 스택에 저장되어있는 탑의 높이와 비교
				if(num <= sk.peek()[1]) {
					// 앞 탑이 더 높으면 인덱스값 저장 
					sb.append(sk.peek()[0]+" ");
					//break 후 push, 9>8>7 과 같은 상황때문에 push
					break;
				}else {
					// 9>5,7  5 pop
					sk.pop();
				}
			}
			if(i == N) break;
			// 스택이 비었을때 0
			if(sk.isEmpty()) sb.append("0 ");
			sk.push(new int[] {i,num});
		}
		System.out.println(sb);
	}
}