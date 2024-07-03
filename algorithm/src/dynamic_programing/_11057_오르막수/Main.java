package dynamic_programing._11057_오르막수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        Arrays.fill(dp[1], 0, 10, 1);

        for(int i=1; i<=N; i++) {
            for(int j=0; j<10; j++) {
                int start = dp[i][j];
                dp[i][j] = Arrays.stream(dp[i-1])
                        .skip(j)
                        .reduce(start, (a, b) -> a + b % mod);
            }
        }

        int sum = Arrays.stream(dp[N]).sum();
        System.out.println(sum % mod);
    }
}
