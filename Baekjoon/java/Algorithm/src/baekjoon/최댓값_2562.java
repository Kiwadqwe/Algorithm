package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 최댓값_2562 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tp;
		int num = 0;
		int idx = 0;
		
		for (int i=0; i<9; i++) {
			tp = Integer.parseInt(br.readLine());
			
			if (tp > num) {
				num = tp;
				idx = i;
			}
		}
		System.out.println(num);
		System.out.println(idx+1);
	}
}