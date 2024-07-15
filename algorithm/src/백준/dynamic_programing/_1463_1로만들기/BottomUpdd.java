package 백준.dynamic_programing._1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 오답 : 1을 1로만들려면 1이 아니라 0이다.
 */
public class BottomUpdd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }

        System.out.println(dp[N]);
    }
}
