package swexpertacademy;

import java.io.*;
import java.util.*;

public class 암호문1_1228_D3 {
	static int N,M,X,Y;
	static LinkedList<String> list;
	static ArrayList<String> arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			
			list = new LinkedList<>();
			st = new StringTokenizer(br.readLine()," ");
			// 원본 암호문 저장
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			// 명령어 개수
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			// 명령어 입력
			for (int i = 0; i < M; i++) {
				String ipu = st.nextToken();
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				arr = new ArrayList<>();
				
				for (int j = 0; j < Y; j++) {
					arr.add(st.nextToken());
				}
				list.addAll(X,arr);
			}
			System.out.print("#"+t+" ");
			for (int j = 0; j < 10; j++) {
				System.out.print(list.get(j)+" ");
			}
			System.out.println();
		}
	}
}