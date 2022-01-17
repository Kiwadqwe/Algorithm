package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_단어수학_1339_G4 {
    static int N,result,temp;
    static String[] array;
    static List<Character> list = new ArrayList<>();
    static int[] choosed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        array = new String[N];
        for(int i=0; i<N; i++){
            array[i] = br.readLine();
            for(int j=0; j<array[i].length(); j++){
                char c = array[i].charAt(j);
                if(!list.contains(c)){
                    list.add(c);
                }
            }
        }

        choosed = new int[list.size()];
        permu(0, new boolean[10], new int[list.size()]);
        System.out.println(result);
    }

    private static void permu(int idx, boolean[] visited, int[] choosed){
        if(idx == list.size()){
            temp = 0;
            for(int i=0; i<N; i++){
                int num = 0;
                for(int j=0; j<array[i].length(); j++){
                    // pow로 접근시에는 시간 초과
                    num *= 10;
                    num += choosed[list.indexOf(array[i].charAt(j))];
                }
                temp += num;
            }

            result = Math.max(result,temp);
            return;
        }

        for(int i=0; i<=9; i++){
            if(!visited[i]){
                visited[i] = true;
                choosed[idx] = i;
                permu(idx+1,visited,choosed);
                visited[i] = false;
            }
        }
    }
}