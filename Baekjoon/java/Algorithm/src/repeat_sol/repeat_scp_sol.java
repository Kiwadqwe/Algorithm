package repeat_sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class repeat_scp_sol {
	static int N,M,c_cnt,p_cnt,s_cnt;
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		array = new int[N];
		for (int i = 1; i < N+1; i++) {
			array[i-1] = i;
		}
		
		comb(0,0,new int[M]);
		System.out.println("조합은? " + c_cnt);
		permu(new boolean[7],0,new int[M]);
		System.out.println("순열은? "  + p_cnt);
		subset(0,0,new int[M]);
		System.out.println("부분집합은? " + s_cnt);
		
	}

	private static void subset(int start, int idx, int[] choosed) {
		if(idx == M) {
			s_cnt++;
//			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		subset(start,idx+1,choosed);
		choosed[start] = array[idx];
		subset(start+1,idx+1,choosed);
	}

	private static void permu(boolean[] visited, int idx, int[] choosed) {
		if(idx == M) {
			p_cnt++;
//			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[idx] = array[i];
				permu(visited,idx+1,choosed);
				visited[i] = false;
			}
		}
	}

	private static void comb(int start, int idx, int[] choosed) {
		if(idx == M) {
			c_cnt++;
//			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for (int i = start; i < N; i++) {
			choosed[idx] = array[i];
			comb(i+1,idx+1,choosed);
		}
	}


}
