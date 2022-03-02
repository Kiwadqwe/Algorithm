package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_소가길을건너간이유1_14467_S5 {
    static int N,cnt;
    static int[] cow,road;

    public static void main(int[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        cow = new int[11];
        road = new int[11];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(cow[n] == 0){
                if(r == 0){
                    road[n] = 1;
                }else{
                    road[n] = 2;
                }
                cow[n]++;
            }else if(0 < cow[n]){
                if(r+1 != road[n]){
                    road[n] = r+1;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}