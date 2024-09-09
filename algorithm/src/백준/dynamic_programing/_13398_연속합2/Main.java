package 백준.dynamic_programing._13398_연속합2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        int max = arr[0];
        for(int i=1; i<N; i++) {
            dp[i][0] = Math.max(arr[i], dp[i-1][0] + arr[i]);
            // 도중 끊어지면 안되기 때문에 dp[i-1][0] 랑 비교한다.
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
    }
}
