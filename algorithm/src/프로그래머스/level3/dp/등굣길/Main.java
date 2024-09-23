package 프로그래머스.level3.dp.등굣길;

public class Main {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        int[][] dp = new int[n][m];

        // 물웅덩이 위치를 표시
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        // 시작 위치
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;  // 물웅덩이인 경우 경로 수를 0으로 설정
                    continue;
                }
                // 단순 i조건과 j조건을 +한다면 int 범위 초과하기 때문에 각각 계산
                if (i > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                if (j > 0) dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}
