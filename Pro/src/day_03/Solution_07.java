package day_03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_07 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/day_03/input_07.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 0; tc < 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            String key = br.readLine();
            String str = br.readLine();

            int cnt = str.length();
            str = str.replace(key, "");
            int ans = (cnt - str.length()) / key.length();

            // char[] key = br.readLine().toCharArray();
            // char[] str = br.readLine().toCharArray();

            // int idx = 0;
            // while(idx != str.length){
            // if(str[idx] == key[0]){
            // for (int i = 0; i < key.length; i++) {

            // }
            // }
            // }

            System.out.println("#" + (tc + 1) + " " + ans);
        }
    }
}