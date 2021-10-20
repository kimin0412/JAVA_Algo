package day_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_12 {
    // static String[] arr = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX",
    // "SVN", "EGT", "NIN" };

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/day_03/input_09.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write("#" + tc + "\n");

            String str = br.readLine();
            String[] numbers = str.split(" ");
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                switch (numbers[i]) {
                    case "ZRO":
                        nums[i] = 0;
                        break;
                    case "ONE":
                        nums[i] = 1;
                        break;
                    case "TWO":
                        nums[i] = 2;
                        break;
                    case "THR":
                        nums[i] = 3;
                        break;
                    case "FOR":
                        nums[i] = 4;
                        break;
                    case "FIV":
                        nums[i] = 5;
                        break;
                    case "SIX":
                        nums[i] = 6;
                        break;
                    case "SVN":
                        nums[i] = 7;
                        break;
                    case "EGT":
                        nums[i] = 8;
                        break;
                    case "NIN":
                        nums[i] = 9;
                        break;
                    default:
                        break;
                }
            }
            Arrays.sort(nums);

            String[] ans = new String[n];
            for (int i = 0; i < n; i++) {
                switch (nums[i]) {
                    case 0:
                        ans[i] = "ZRO";
                        break;
                    case 1:
                        ans[i] = "ONE";
                        break;
                    case 2:
                        ans[i] = "TWO";
                        break;
                    case 3:
                        ans[i] = "THR";
                        break;
                    case 4:
                        ans[i] = "FOR";
                        break;
                    case 5:
                        ans[i] = "FIV";
                        break;
                    case 6:
                        ans[i] = "SIX";
                        break;
                    case 7:
                        ans[i] = "SVN";
                        break;
                    case 8:
                        ans[i] = "EGT";
                        break;
                    case 9:
                        ans[i] = "NIN";
                        break;
                    default:
                        break;
                }
            }
            // for (int i = 0; i < n - 1; i++) {
            // bw.write(arr[nums[i]] + " ");
            // }
            // bw.write(arr[nums[n - 1]] + "\n");

            for (int i = 0; i < n - 1; i++) {
                bw.write(ans[i] + " ");
            }
            bw.write(ans[n - 1] + "\n");
            bw.flush();
            bw.close();
        }
    }
}