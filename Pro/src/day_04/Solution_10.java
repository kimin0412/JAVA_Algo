package day_04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_10 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/day_04/input_10.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < 2 + 1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int x = N / P;
            int y = x + 1;
            int a = P * x;
            int yCnt = N - a;
            int xCnt = P - yCnt;
            long ans = (long) (Math.pow(x, xCnt) * Math.pow(y, yCnt));
            System.out.println("#" + tc + " " + ans);
        }
    }
}