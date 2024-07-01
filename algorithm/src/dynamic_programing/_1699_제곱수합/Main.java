package dynamic_programing._1699_제곱수합;

import java.io.*;

import static java.lang.Integer.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int sqrt = (int) Math.sqrt(N);
        int[] dp = new int[N + 1];

        for(int i=0; i<=N; i++) {
            dp[i] = i;
        }

        for(int i=2; i<sqrt+1; i++) {
            int pow = (int) Math.pow(i, 2);

            for(int j = pow; j<=N; j++) {
                int num = j / pow;
                dp[j] = Math.min(dp[j], num + dp[(j - num * pow)]);
            }
        }

        System.out.println(dp[N]);
    }
}
