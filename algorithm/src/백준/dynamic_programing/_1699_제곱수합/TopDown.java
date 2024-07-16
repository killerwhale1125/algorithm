package 백준.dynamic_programing._1699_제곱수합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopDown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[N - 1] + dp[N - (N - 1)], dp[N - 2] + dp[N - (N - 2)]);
        }
        System.out.println(dp[N]);
    }
}
