package 백준.dynamic_programing._11052_카드구매하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] card = new int[N + 1];    // 최대 1000
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=1; i<=N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;

        for(int i=1; i<=N; i++) {
            int price = card[i];
            // i는 카드 갯수
            // j는 카드 팩
            for(int j=i; j<=N; j++) {
                dp[j] = Math.max(dp[j], dp[j-i] + price);
            }
        }
        System.out.println(dp[N]);
    }
}
