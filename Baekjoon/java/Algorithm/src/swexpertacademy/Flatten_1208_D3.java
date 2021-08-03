package swexpertacademy;

import java.io.*;
import java.util.*;

public class Flatten_1208_D3 {
	static int[] array;
	 static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
         
        for (int t= 1; t < 11; t++) {
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            array = new int[100];
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            while(true) {
                Arrays.sort(array);
                if (cnt<=0) {
                    break;
                }
                array[99] -=1;
                array[0] +=1;
                cnt-=1;
            }
            sb.append("#"+t+" "+(array[99]-array[0])+"\n");
        }
        System.out.println(sb);
    }
}