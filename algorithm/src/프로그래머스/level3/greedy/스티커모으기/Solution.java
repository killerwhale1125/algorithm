package 프로그래머스.level3.greedy.스티커모으기;

public class Solution {
    public static void main(String[] args) {
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println(solution(sticker));
    }

    private static int solution(int[] sticker) {
        int n = sticker.length;

        // 예외 처리: 스티커가 한 개만 있을 경우
        if (n == 1) {
            return sticker[0];
        }

        // 첫 번째 스티커를 선택하는 경우
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // 첫 번째 스티커를 선택하지 않는 경우
        int[] dp2 = new int[n];
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        // 두 경우의 최대값 반환
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
