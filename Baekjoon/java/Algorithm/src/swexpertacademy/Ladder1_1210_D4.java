package swexpertacademy;

import java.io.*;
import java.util.*;

public class Ladder1_1210_D4 {
    static int tc, x, y;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int t = 1; t <= 10; t++) {
            tc = Integer.parseInt(br.readLine());
            map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }
            
            while (true) {
                x += dx[0]; // row
                y += dy[0]; // col
                if (x == 0) break;
                if (0 <= x && x < 100 && 0 <= y && y < 100) {
                    if (y + 1 < 100 && map[x][y + 1] == 1) move(1);
                    else if (0 <= y - 1 && map[x][y - 1] == 1) move(3);
                }
            }

            System.out.println("#" + tc + " " + y);
        }
    }

    private static void move(int k) {
        while (true) {
            x += dx[k];
            y += dy[k];
            if (x < 0 || y < 0 || x >= 100 || y >= 100 || map[x][y] == 0) {
                x -= dx[k];
                y -= dy[k];
                break;
            }
        }
    }
}