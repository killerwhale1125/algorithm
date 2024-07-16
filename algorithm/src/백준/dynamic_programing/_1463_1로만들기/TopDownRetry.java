package 백준.dynamic_programing._1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopDownRetry {
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        topDown(N);
    }

    private static int topDown(int X) {
        if(X == 1) return 0;

        if(dp[X] != 0) return dp[X];

        /**
         * dp[X] return -> -1 값을 증명하기 위함
         */
        dp[X] = topDown(X - 1) + 1;
        if(X % 3 == 0) dp[X] = Math.min(dp[X], topDown(X / 3) + 1);
        if(X % 2 == 0) dp[X] = Math.min(dp[X], topDown(X / 2) + 1);

        return dp[X];
    }
}
