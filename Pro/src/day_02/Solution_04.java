package day_02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_04 {
    static int size, n;  // 숫자 크기와 교환 횟수
    static int max;  // 교환으로 만들 수 있는 최대값
    static boolean[][] visit;  // 방문체크용
    static int[] arr;  // 숫자를 담을 배열

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/day_02/input_04.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            size = str.length();
            arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = str.charAt(i) - '0';
            }
            n = Integer.parseInt(st.nextToken());
            // 입력 끝

            int cnt = 1;  // 방문체크를 [남은 교환횟수][나온 값] 으로 할것이기 때문에 숫자로 만들 수 있는 최대값을 크기로 해줘야함.
            // 예를들어 6자리 수 라면 999999가 최대이므로 1000000을 배열공간으로

            for (int i = 0; i < size; i++) {
                cnt *= 10;
            }
            visit = new boolean[n + 1][cnt + 1];
            solve(n);
            System.out.println("#" + test_case + " " + max);
        }
    }

    private static void solve(int n) {
        int ans = 0; // int 배열을 자릿수 곱하면서 수로 만들어 주기
        for (int i = 0; i < size; i++) {
            ans += arr[i] * Math.pow(10, size - i - 1);
        }

        if (visit[n][ans]) { // 만약 남은 교환횟수가 같고 현재 값은 배열을 방문한 적이 (처리한 적이) 있었다면
            return; // 돔황챠
        } else // 처음이라면
            visit[n][ans] = true; // 방문 표시

        if (n == 0) { // 남은 교환횟수가 0이라면
            max = Math.max(max, ans); // 최대값 판별해주고
            return; // 돔황챠~
        }

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i != j) { // 자기자신이랑 바꿀 필요가 없으니까 스킵
                    int tmp = arr[i]; // 자리 바꿔주기
                    arr[i] = arr[j];
                    arr[j] = tmp;

                    solve(n - 1); // 배열 자리 바꾼 상태로 교환횟수-1 인 함수 호출

                    tmp = arr[i];  // 교환했던거 다시 돌려놓기
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}