package baekjoon_r;

import java.util.*;

public class BJ_모든순열_10974_S3 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        permu(0,new boolean[N],new int[N]);

    }

    private static void permu(int idx, boolean[] visited, int[] choosed){
        if(idx == N){
            for(int c: choosed){
                System.out.print(c+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                choosed[idx] = i+1;
                permu(idx+1, visited,choosed);
                visited[i] = false;
            }
        }
    }
}