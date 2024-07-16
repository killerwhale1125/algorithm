package 백준.dynamic_programing._2193_이친수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        // 초기값 설정
        dp[1] = 1; // 1자리 이친수는 1밖에 없음
        if (N >= 2) {
            dp[2] = 1; // 2자리 이친수는 10 하나만 가능
        }

        // 점화식을 통한 dp 배열 채우기
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}
