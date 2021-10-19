package day_01;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_01 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/day_01/input_01.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int ans = 0;
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 4];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 2; i <= N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 2; i <= N; i++) {
                int left1 = arr[i] - arr[i - 1];
                int left2 = arr[i] - arr[i - 2];
                int right1 = arr[i] - arr[i + 1];
                int right2 = arr[i] - arr[i + 2];

                if (left1 < 0 || left2 < 0 || right1 < 0 || right2 < 0)
                    continue;

                ans += Math.min(left1, Math.min(left2, Math.min(right1, right2)));
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}