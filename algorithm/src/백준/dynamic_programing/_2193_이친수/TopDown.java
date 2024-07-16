package 백준.dynamic_programing._2193_이친수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TopDown {
    public static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        System.out.println(topDown(N));
    }

    private static long topDown(int X) {
        if(dp[X] == -1)
            dp[X] = topDown(X - 1) + topDown(X - 2);
        return dp[X];
    }
}
