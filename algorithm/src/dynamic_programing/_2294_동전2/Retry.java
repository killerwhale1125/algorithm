package dynamic_programing._2294_동전2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int SUM = Integer.parseInt(st.nextToken());

        int[] dp = new int[SUM + 1];
        int[] coins = new int[N];

        for(int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        /**
         * 100001로 값을 채움으로 인하여 만들지 못하는 동전을 저장
         */
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i=0; i<N; i++) {
            // 현재 코인
            int coin = coins[i];
            for(int j=coin; j<=SUM; j++) {
                Math.min(dp[j], dp[j - coin] + 1);
            }
        }
    }
}
