package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_암호만들기_1759_G5 {
    static int L,C;
    static char[] array;
    static char[] mo = {'a','e','i','o','u'};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        array = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            array[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(array);
        comb(0,0,new char[L]);
        System.out.print(sb);
    }

    private static void comb(int start, int idx, char[] choosed){
        if(idx == L){
            int cnt = 0;
            for (char value : mo) {
                for (char c : choosed) {
                    if (value == c) {
                        cnt++;
                        break;
                    }
                }
            }
            if(L-1 <= cnt || cnt == 0) return;

            for(int i=0; i<L; i++){
                sb.append(choosed[i]);
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<C; i++){
            choosed[idx] = array[i];
            comb(i+1, idx+1, choosed);
        }
    }
}