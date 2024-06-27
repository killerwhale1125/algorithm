package dynamic_programing._1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopDown {
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        System.out.println(dp(N));
    }

    private static int dp(int X) {

        if(X == 1) {
            return 0;
        }

        // 메모제이션
        if(dp[X] > 0) {
            return dp[X];
        }

        dp[X] = dp(X - 1) + 1;

        if(X % 2 == 0) {
            dp[X] = Math.min(dp[X], dp(X / 2) + 1);
        }

        if(X % 3 == 0) {
            dp[X] = Math.min(dp[X], dp(X / 3) + 1);
        }

        return dp[X];
    }
}
