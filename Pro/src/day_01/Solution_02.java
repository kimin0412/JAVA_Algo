package day_01;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_02 {
    static String[] code = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
            "0110111", "0001011" };

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/day_01/input_02.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            int[] ansArr = new int[8];
            int ans = 0;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = M - 1; j >= 0; j--) {
                    if (!flag && arr[i][j] == 1) {
                        flag = true;
                        int start = j;
                        for (int k1 = 0; k1 < 8; k1++) {
                            String s = "";
                            for (int k2 = 0; k2 < 7; k2++) {
                                s = arr[i][start] + "" + s;
                                start--;
                            }
                            for (int k = 0; k < 10; k++) {
                                if (code[k].equals(s)) {
                                    ans += k;
                                    ansArr[k1] = k;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
            int fact = 0;
            fact = (ansArr[1] + ansArr[3] + ansArr[5] + ansArr[7]) * 3 + (ansArr[2] + ansArr[4] + ansArr[6])
                    + ansArr[0];
            if (fact % 10 == 0) {
                System.out.println("#" + test_case + " " + ans);
            } else {
                System.out.println("#" + test_case + " " + 0);
            }

        }
    }
}