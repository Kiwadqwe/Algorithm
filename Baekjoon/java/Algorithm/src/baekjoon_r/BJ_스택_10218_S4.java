package baekjoon_r;

import java.io.*;
import java.util.*;

public class BJ_스택_10218_S4 {
    static int N;
    static Stack<String> sk = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                sk.push(st.nextToken());
            }else if(s.equals("top")){
                if(sk.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(sk.peek());
                }
            }else if(s.equals("size")){
                System.out.println(sk.size());
            }else if(s.equals("empty")){
                if(sk.isEmpty()){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }else if(s.equals("pop")){
                if(sk.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(sk.pop());
                }
            }
        }
    }
}
