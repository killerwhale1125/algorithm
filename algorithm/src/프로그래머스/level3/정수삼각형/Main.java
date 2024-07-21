package 프로그래머스.level3.정수삼각형;

import java.util.Arrays;

/**
 * 밑에서부터 위로 한칸씩 메모제이션 하면서 맨위로 올라가기
 * 맨 아래부터 두개씩 왼쪽 오른쪽 잡고 위에 값이랑 각각 더해서 뭐가 더큰건지 구하여 dp 저장
 */
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

        // size -1 은 배열 맞출려고
        for(int i=size-1; i>=0; i--) {
            for(int j=1; j<i+1; j++) {
                dp[i-1][j-1] = Math.max(triangle[i-1][j-1] + dp[i][j-1], triangle[i-1][j-1] + dp[i][j]);
            }
        }

        System.out.println(dp[0][0]);
    }
}
