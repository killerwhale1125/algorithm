package 백준.dynamic_programing._1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[1] = 0;
        if(N > 1) {
            dp[2] = 1;
        }

        if(N > 2) {
            dp[3] = 1;
        }

        for(int i=4; i<=N; i++) {
            int min = Integer.MAX_VALUE;
            int X = i;

            /** 조건 계산 **/
            if(X % 3 == 0) {
                min = Math.min(min, dp[X/3]);
            }
            if(X % 2 == 0) {
                min = Math.min(min, dp[X/2]);
            }
            min = Math.min(min, dp[X-1]);

            if(min == Integer.MAX_VALUE) {
                min = 1;
            }

            dp[i] = min + 1;
        }

        System.out.println(dp[N]);
    }
}
