package dynamic_programing._1904_01타일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp;
    public static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        num = 15746;

        dp[0] = 0;
        dp[1] = 1;
        if(N > 1) {
            dp[2] = 2;
        }

        for(int i=3; i<=N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
            dp[i] %= num;
        }

        System.out.println(dp[N] % num);
    }
}
