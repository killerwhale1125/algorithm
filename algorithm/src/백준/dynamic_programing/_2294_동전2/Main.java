package 백준.dynamic_programing._2294_동전2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 처음 생각했던 방안
 * arr 배열을 사용하지 않고 초기 값 수동으로 기입하여 해나가는 방식
 * 문제점 -> 기존 arr 배열 ex ) 1, 5, 12 등 이 값들을 사용하지 않았음을 나중에 눈치챔
 * 
 *  핵심
 *  - coins[i]부터 K까지 각각 값마다 최솟값을 메모제이션
 *  - 무조건 해당 값을 사용하여 메모제이션. ex) 5동전을 무조건 사용해야하기 때문에 K가 8일 경우 8-5해서 3의 최솟값을 +
 *  
 *  1. 입력값으로 주어진 코인의 정보를 통하여 for문 반복
 *  2. 입력으로 주어진 코인 값마다 각각 그 코인값[i] ~ K 까지 최솟값을 메모제이션
 *  3. 값 출력
 */
public class Main {
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

        // dp 배열 초기화
        Arrays.fill(dp, 10001); // 문제 조건에서 10000 이하의 자연수이므로 최대 10001로 초기화

        dp[0] = 0; // 0원을 만드는 동전 개수는 0개

        // arr 배열 루프
        for (int i = 0; i < N; i++) {
            /**
             * +1 -> 현재 사용중인 코인 값
             * dp[j - coins[i]] -> dp[구해야하는 값 - 현재 사용중인 코인 값]
             * dp[j]와 비교하는 이유는 만약 i-1 때 메모제이션했던 값이 더 작을 수도 있음
             */
            for (int j = coins[i]; j <= K; j++) {
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
