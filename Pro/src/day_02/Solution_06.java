package day_02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_06 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/day_02/input_06.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc < 11; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken().trim());
                }
            }

            boolean flag = false;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                flag = false;
                for (int j = 0; j < N; j++) {
                    if (map[j][i] == 1) {
                        flag = true;
                    }

                    else if (flag == true && map[j][i] == 2) {
                        cnt++;
                        flag = false;
                    }

                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}