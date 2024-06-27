package dynamic_programing._2193_이친수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(dynamic(N));
    }

    private static int dynamic(int N) {
        if(N == 0) {
            return 0;
        }

        if(dp[N] > 0) {
            return dp[N];
        }

        return dynamic(N - 1) + dynamic(N - 2);

    }
}
