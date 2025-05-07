package 백준.dynamic_programing._17070_파이프옮기기1;

import java.io.*;
import java.util.*;

/**
 * 초기 오답 풀이
 * -> 가로, 세로, 대각 방향을 미리 배열로 지정해놓고 탐색
 * 문제점 -> 각 방향마다 중복된 값을 판단하기 까다로움. Set도 hashcode 때문에 혼란
 *
 * 가로 -> 0
 * 세로 -> 1
 * 대각선 -> 2
 * 3차원 배열 사용하여 가로 세로 대각 각각 분리하여 풀이
 */
public class Solution {
    private static int[][] map;
    private static int[][][] dp;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1; // 시작 위치 -> (0,1) 에 가로 방향

        for (int x = 0; x < N; x++) {
            for (int y = 2; y < N; y++) {
                if (map[x][y] == 1) continue;

                /* 가로는 대각선 방향과 가로 두가지 */
                dp[x][y][0] = dp[x][y - 1][0] + dp[x][y - 1][2];

                /* 1 이하는 세로 자체가 올 수가 없음
                * 세로는 대각선 방향과 세로 방향 두가지
                * */
                if (x > 1) {
                    dp[x][y][1] = dp[x - 1][y][1] + dp[x - 1][y][2];
                }

                /* 대각선 방향은 가로 세로 대각선 3가지가 가능함. 따라서 대각선 방향의 가로 세로 대각 방향의 값을 더해준다. */
                if (x > 0 && map[x - 1][y] == 0 && map[x][y - 1] == 0) {
                    dp[x][y][2] = dp[x - 1][y - 1][0] + dp[x - 1][y - 1][1] + dp[x - 1][y - 1][2];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }
}
