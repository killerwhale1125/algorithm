package 프로그래머스.level3.정수삼각형;

import java.util.Arrays;

public class Main {
    public static int[][] dp;
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int size = triangle.length;
        dp = new int[size][size];

        for(int i=0; i<size; i++) {
            if(i == size - 1) {
                for(int j=0; j<size; j++) {
                    dp[size - 1][j] = triangle[size - 1][j];
                }
            } else {
                Arrays.fill(dp[i], -1);
            }
        }


        for(int i=0; i<size; i++) {

        }

        for(int i=size-1; i>=0; i--) {
            int length = dp[i].length;

            for(int j=1; j<i+1; j++) {
                int value = triangle[i-1][j-1];
                int result = Math.max(value + dp[i][j-1], value + dp[i][j]);
                dp[i-1][j-1] = Math.max(dp[i-1][j-1], result);
            }
        }

        System.out.println(dp[0][0]);
    }
}
