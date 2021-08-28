package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_17413_단어뒤집기2_S3 {
	static StringBuilder sb;
	static Queue<Character> q;
	static Stack<Character> sk;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String s = br.readLine();
		
		q = new LinkedList<Character>();
		sk = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			q.add(s.charAt(i));
		}
		
		while(!q.isEmpty()) {
			char c = q.poll();
			
			if(c == '<') {
				stext(c);
			}else {
				text(c);
			}
		}
		System.out.println(sb);
	}

	private static void ski() {
		for (int j = sk.size()-1; j >=0; j--) {
			sb.append(sk.pop());
		}
	}

	private static void text(char c) {
		sk.add(c);
		while(true) {
			c = q.poll();
			// 뒤집기는 스택 사용으로
			// <가 나오면  이때까지 스택에 저장했던거 pop
			if(c == '<') {
				ski();
				stext(c);
				return;
			// 공백나오면 다음 단어로 넘어가니깐 이때까지 저장했던거 뺌
			}else if(c == ' ') {
				ski();
				sb.append(c);
			// 공백이나 < 나올때까지 스택에 추가
			}else {
				sk.add(c);
			}
			// 큐가 비면 스택에 저장했던거 뺌
			if(q.isEmpty()) {
				ski();
				return;
			}
		}
	}

	private static void stext(char c) {
		// >가 나올때까지 append
		sb.append(c);	
		while(!q.isEmpty()) {
			c = q.poll();
			sb.append(c);	
			if(c == '>') return;
		}
	}
}