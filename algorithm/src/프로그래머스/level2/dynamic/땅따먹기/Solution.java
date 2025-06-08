package 프로그래머스.level2.dynamic.땅따먹기;

import java.util.Arrays;

class Solution {
    public int solution(int[][] land) {
        int N = land.length;
        int M = land[0].length;
        int[][] dp = new int[N][M];

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
                }
            }
        }

        return Arrays.stream(dp[N - 1]).max().getAsInt();
    }
}