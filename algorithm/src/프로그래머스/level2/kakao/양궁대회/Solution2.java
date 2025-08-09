package 프로그래머스.level2.kakao.양궁대회;

import java.util.*;

class Solution2 {
    private int[] apeach;
    private int[] answer = {-1};
    private int max = Integer.MIN_VALUE;

    private void saveScoreIfMax(int score, int[] ryan) {
        if (score > max) {
            max = score;
            answer = ryan.clone();
            return;
        }

        if (score == max) {
            for (int i = 10; i >= 0; i--) {
                if (ryan[i] > answer[i]) {
                    answer = ryan.clone();
                    return;
                }

                if (ryan[i] < answer[i]) return;
            }
        }
    }

    private int calculate(int[] ryan) {
        int ryanTotal = 0;
        int apeachTotal = 0;
        for (int i = 0; i < 11; i++) {
            int ryanScore = ryan[i];
            int apeachScore = apeach[i];

            if (ryanScore == 0 && apeachScore == 0) continue;

            if (ryanScore > apeachScore) {
                ryanTotal += 10 - i;
                continue;
            }

            apeachTotal += 10 - i;
        }

        return ryanTotal - apeachTotal;
    }

    private void dfs(int cur, int arrow, int[] ryan) {
        if (cur == 11) {
            if (arrow > 0) {
                ryan[10] += arrow;
            }

            int ryanScore = calculate(ryan);
            if (ryanScore > 0) {
                saveScoreIfMax(ryanScore, ryan);
            }

            if (arrow > 0) {
                ryan[10] -= arrow;
            }

            return;
        }

        if (apeach[cur] < arrow) {
            ryan[cur] = apeach[cur] + 1;
            dfs(cur + 1, arrow - ryan[cur], ryan);
            ryan[cur] = 0;
        }

        // 안쏜다
        dfs(cur + 1, arrow, ryan);
    }

    public int[] solution(int n, int[] a) {
        apeach = a;
        dfs(0, n, new int[11]);
        return answer;
    }
}