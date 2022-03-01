package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_빗물_14719_G5 {
    static int W,H,result;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        array = new int[H];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < H; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        go();
        System.out.println(result);
    }

    private static void go(){
        for (int i = 1; i < H; i++) {
            int l = 0;
            int r = 0;

            //  현재 위치에서 왼쪽으로 가장 큰 값
            for (int j = 0; j < i; j++) {
                l = Math.max(l,array[j]);
            }

            // 현재 위치에서 오른쪽으로 가장 큰값
            for (int j = i; j < H; j++) {
                r = Math.max(r,array[j]);
            }

            // 물이 고일 수 있는 층
            int m = Math.min(l,r);

            // 높이가 같거나 현재 위치보다 높으면 물이 고일 수 있음
            if(array[i] <= m){
                // 고인 물의 높이
                result += m-array[i];
            }
        }
    }
}