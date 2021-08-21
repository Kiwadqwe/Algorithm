package swexpertacademy;

import java.io.*;
import java.util.*;

public class 계산기2_1233_D4 {
	static int N;
	static char[] ch;
	static List<Character> arr;
	static Stack<Integer> sk2;
	static Stack<Character> sk;
	static String s;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new ArrayList<>();
			ch = new char[N];
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
				
			post();
			cal();
			sb.append("#").append(t).append(" ").append(sk2.pop()).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void post() {
		sk = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 피연산자면 추가
			if('0' <= c && c <= '9') {
				arr.add(c);
			}else {
				// 현재 스택에 연산자가 없을때
				if(sk.isEmpty()) {
					sk.push(c);
					continue;
				}
				// 우선순위가 같거나 낮으면 pop 해야함
				if(sk.peek() == '*') {
					arr.add(sk.pop()); 
				}
					sk.push(c);
			}
		}
		while(!sk.isEmpty()) {
			arr.add(sk.pop());
	}	
}

	private static void cal() {
		sk2 = new Stack<>();
		int tp = 0;
		int tp2 = 0;
		int hap = 0;
		
		while(!arr.isEmpty()) {
			char c = arr.remove(0);
			if('0' <= c && c <= '9') {
				sk2.push(c - '0');
			}else {
				// 연산자면 숫자 두개 추출
				tp = sk2.pop();
				tp2 = sk2.pop();
				if(c == '+') {
					hap = tp+tp2;
				}else if(c == '*') {
					hap = tp*tp2;
				}
				sk2.push(hap);
			}
		}
		
	}
}