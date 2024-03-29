//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_공항_10775_G2 {
    static int[] p;
    static int G;
    static int P;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt((new StringTokenizer(br.readLine())).nextToken());
        P = Integer.parseInt((new StringTokenizer(br.readLine())).nextToken());
        p = new int[G + 1];

        int i;
        for(i = 0; i < G + 1; p[i] = i++) {
        }

        for(i = 0; i < P; ++i) {
            int A = Integer.parseInt((new StringTokenizer(br.readLine())).nextToken());
            int f = find(A);
            if (f == 0) {
                break;
            }

            p[f] = p[f - 1];
            ++result;
        }

        System.out.println(result);
    }

    public static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }

        return p[x];
    }
}
