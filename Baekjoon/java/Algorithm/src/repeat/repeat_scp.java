package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class repeat_scp {
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


}