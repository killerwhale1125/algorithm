package dynamic_programing._10844_쉬운계단수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 해설 링크
 * https://yinq.tistory.com/72#-%EC%-C%BC%EB%A-%-C%--%EC%-B%-C%EC%-E%--%ED%--%--%EB%-A%--%--%EA%B-%BD%EC%-A%B-
 * 
 * 비슷하게 풀었으나 조금 더 생각해봤었어야함.
 * 문제를 잘못 읽음
 */

public class Main {
    final static long mod = 1000000000;
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N+1][10];

        Arrays.fill(dp[1], 1, 10, 1);

        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) {
                if(j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                }
                // j=9라면 이전 자릿수는 8만 가능
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                }
                // 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

//        Arrays.stream(dp).skip(1).limit(N - 1).forEach(i -> {
//            int idx = Arrays.asList(dp).indexOf(i); // -> 첫번째 for문 idx
//            Arrays.setAll(dp[idx + 1], j -> setNumber(idx, j));
//        });

        long result = Arrays.stream(dp[N]).reduce(Long::sum).getAsLong();
        System.out.println(result % mod);

    }

//    public static long setNumber(int i, int j) {
//        if (j == 0) {
//            return dp[i][1] % mod;
//        } else if (j == 9) {
//            return dp[i][8] % mod;
//        } else {
//            return (dp[i][j - 1] + dp[i][j + 1]) % mod;
//        }
//    }
}
