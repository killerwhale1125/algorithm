package dynamic_programing._1699_제곱수합;

import java.io.*;

import static java.lang.Integer.*;

/**
 * 동전 2와는 다르게 어떤 값을 사용해야할지 동전같은 값들이 주어지지 않음
 * 따라서 몇번 반복해야 하는지는 Math.sqrt를 통하여 제곱근 수 만큼 반복함 ex ) 11 -> 3번 반복
 * 3번 반복 이유는 4부터는 제곱하면 16이라서 11을 넘어가기 때문에 안됨
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int sqrt = (int) Math.sqrt(N);
        int[] dp = new int[N + 1];

        /**
         * 동전 2와는 다르게 무조건 1부터 시작하기 때문에 아래와 같이 행[1]은 수동으로 초기화 가능
         */
        for(int i=0; i<=N; i++) {
            dp[i] = i;
        }

        /**
         * 2부터는 제곱 수 부터 탐색 시작
         * 이유는 2의 제곱은 4인데 3은 나올수가 없음.
         * 그리고 3은 초기에 위에서 초기화했기 때문에 비교하며 메모제이션 가능
         */
        for(int i=2; i<sqrt+1; i++) {
            int pow = (int) Math.pow(i, 2);

            for(int j = pow; j<=N; j++) {
                /**
                 * ex ) 15(j) / 2^2(pow) -> 2의 제곱인 4가 15에는 3번들어갈 수 있음
                 *      num = 3
                 */
                int num = j / pow;

                /**
                 * j - num * pow -> 15(j) - (3 * 2^2) -> dp[15 - 12] -> dp[3]
                 * 즉 현재 제곱수로 가장 효율적으로 계산 가능한 num과 dp[3] 을 더함
                 */
                dp[j] = Math.min(dp[j], num + dp[(j - num * pow)]);
            }
        }

        System.out.println(dp[N]);
    }
}
