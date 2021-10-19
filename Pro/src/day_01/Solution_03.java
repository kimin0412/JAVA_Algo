package day_01;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_03 {
    /*
     * 최소 한명 = 1 - 둘 다 소수가 아닐 확률
     */

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/day_01/input_03.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] notPnum = { 0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18 };
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int skillOfMasterA = Integer.parseInt(st.nextToken());
            int skillOfMasterB = Integer.parseInt(st.nextToken());

            int[][] combi = new int[19][19];
            for (int i = 1; i < 19; i++) {
                combi[i][0] = 1;
                combi[i][i] = 1;
            }
            for (int i = 1; i < 19; i++) {
                for (int j = 1; j < i; j++) {
                    combi[i][j] = combi[i - 1][j - 1] + combi[i - 1][j];
                }
            }

            double notP1 = 0.0;
            double notP2 = 0.0;
            for (int i = 0; i < 12; i++) {
                int p = notPnum[i];
                double dA1 = (double) skillOfMasterA / 100;
                double dB1 = (double) skillOfMasterB / 100;
                double dA2 = (double) (100 - skillOfMasterA) / 100;
                double dB2 = (double) (100 - skillOfMasterB) / 100;

                notP1 += combi[18][p] * Math.pow(dA1, p) * Math.pow(dA2, (18 - p));
                notP2 += combi[18][p] * Math.pow(dB1, p) * Math.pow(dB2, (18 - p));
            }
            double notP = notP1 * notP2;
            System.out.println("#" + test_case + " " + String.format("%.6f", (1 - notP)));

        }
    }
}