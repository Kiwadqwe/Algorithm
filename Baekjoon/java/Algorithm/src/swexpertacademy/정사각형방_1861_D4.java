package swexpertacademy;

import java.io.*;
import java.util.*;
 
public class 정사각형방_1861_D4 {
    static int TC;
    static int N,cnt;
    static int[][] array;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
         
        TC = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= TC; t++) {
            N = Integer.parseInt(br.readLine());
            array = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int idx = 0;
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    move(i,j);
                    if(result < cnt) {
                        result = cnt;
                        idx = array[i][j];
                    }else if(result == cnt) {
                        if(array[i][j] <idx) { 
                        	idx = array[i][j];
                        }
                    }
                    cnt = 1;
                }
            }
            sb.append("#"+t+" "+idx+" "+result+"\n");
            idx = 0;
            result = 0;
        }
        System.out.print(sb);
    }
     
    private static void move(int x, int y) {
        boolean check = false;
        while(true) {
            for (int i = 0; i < 4; i++) {
                int nx = dx[i]+x;
                int ny = dy[i]+y;
                if(0<=nx && nx<N && 0<=ny && ny<N) {
                    if(array[nx][ny] == array[x][y]+1) {
                        cnt+=1;
                        x = nx;
                        y = ny;
                        check = true;
                        break;
                    } else check = false;                    
                }
            }
            if(!(check)) return;
        }
    }
}