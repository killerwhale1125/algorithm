package 프로그래머스.level2.kakao.양궁대회;

class Solution {
    private int max = Integer.MIN_VALUE;
    private int[] answer = {-1};

    private int calculateDiff(int[] ryan, int[] apeach) {
        int ryanScore = 0, apeachScore = 0;

        for (int i = 0; i <= 10; i++) {
            if (ryan[i] == 0 && apeach[i] == 0) continue;

            if (ryan[i] > apeach[i]) {
                ryanScore += 10 - i;
                continue;
            }

            apeachScore += 10 - i;
        }

        return ryanScore - apeachScore;
    }

    private void saveDiffIfMax(int diff, int[] ryan) {
        if (diff > max) {
            answer = ryan.clone();
            max = diff;
            return;
        }

        if (diff == max) {
            for (int i = 10; i >= 0; i--) {
                if (ryan[i] > answer[i]) {
                    answer = ryan.clone();
                    return;
                }

                if (ryan[i] < answer[i]) return;
            }
        }
    }

    private void dfs(int depth, int arrows, int[] ryan, int[] apeach) {
        if (depth == 11) {
            if (arrows > 0) ryan[10] += arrows;

            int diff = calculateDiff(ryan, apeach);
            if (diff > 0) {
                saveDiffIfMax(diff, ryan);
            }

            if (arrows > 0) ryan[10] -= arrows;
            return;
        }

        // 쏜다
        if (arrows > apeach[depth]) {
            ryan[depth] = apeach[depth] + 1;
            dfs(depth + 1, arrows - ryan[depth], ryan, apeach);
            ryan[depth] = 0;
        }

        // 안쏜다
        dfs(depth + 1, arrows, ryan, apeach);
    }

    public int[] solution(int n, int[] apeach) {
        dfs(0, n, new int[11], apeach);
        return answer;
    }
}