package dynamic_programing._2294_동전2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 10001);

        dp[0] = 0;

        for(int i=0; i<N; i++) {
            for(int j=coins[i]; j<=K; j++) {
                /**
                 * +1 -> 현재 사용중인 코인 값
                 * dp[j - coins[i]] -> dp[구해야하는 값 - 현재 사용중인 코인 값]
                 * dp[j]와 비교하는 이유는 만약 i-1 때 메모제이션했던 값이 더 작을 수도 있음
                 */
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        if (dp[K] == 10001) {
            System.out.println(-1); // 만들 수 없는 경우
        } else {
            System.out.println(dp[K]);
        }
    }
}
