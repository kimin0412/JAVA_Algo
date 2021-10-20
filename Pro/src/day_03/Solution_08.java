package day_03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_08 {
    static int N, size;
    static char[][] map;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/day_03/input_08.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 0; tc < 10; tc++) {
            N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            size = str.length();
            map = new char[size][size];
            for (int i = 0; i < size - 1; i++) {
                map[i] = str.toCharArray();
                str = br.readLine();
            }
            map[size - 1] = str.toCharArray();

            int ans = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j <= size - N; j++) {
                    ans++;
                    int sj = j;
                    int fj = sj + N - 1;
                    for (int k = 0; k < N / 2; k++) {
                        if (map[i][sj] != map[i][fj]) {
                            ans--;
                            break;
                        }
                        sj++;
                        fj--;
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                for (int i = 0; i <= size - N; i++) {
                    ans++;
                    int si = i;
                    int fi = si + N - 1;
                    for (int k = 0; k < N / 2; k++) {
                        if (map[si][j] != map[fi][j]) {
                            ans--;
                            break;
                        }
                        si++;
                        fi--;
                    }
                }
            }
            System.out.println("#" + (tc + 1) + " " + ans);
        }
    }
}