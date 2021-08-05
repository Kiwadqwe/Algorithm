package swexpertacademy;

import java.io.*;
import java.util.*;
 
public class 괄호짝짓기_1218_D4 {
    static String[] text = {"(",")","[","]","{","}","<",">"};
    static int N;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
     
        for (int t = 1; t<=10; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            String s = st.nextToken();
            Stack<Character> sk = new Stack<>();
             
            boolean isCheck = true;
            for (int i = 0; i < N; i++) {
                char c = s.charAt(i);
                if(c == '(' || c == '[' || c == '{' || c == '<') {
                    sk.push(c);
                }else {
                    if(sk.isEmpty()) {
                        isCheck = false;
                        break;
                    }else if(sk.peek() == check(c)) {
                        sk.pop();
                    }else if(!(sk.peek() == check(c))) {
                        isCheck = false;
                        break;
                    }
                }
            }
            if(isCheck) {
                sb.append("#"+t+" "+1+"\n");
            }else {
                sb.append("#"+t+" "+0+"\n");
            }
        }
        System.out.println(sb);
    }
 
    private static char check(char c) {
        if(c == ']') {
            return '[';
        }else if(c == '}') {
            return '{';
        }else if(c == '>') {
            return '<';
        }else {
            return '(';
        }
    }
}