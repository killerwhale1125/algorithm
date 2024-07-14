package 백준.dynamic_programing._9465_스티커;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            int T = Integer.parseInt(br.readLine());

            int[][] board = new int[2][T];
            int[][] dp = new int[2][T];

            for(int j=0; j<2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<T; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (T == 1) {
                System.out.println(Math.max(board[0][0], board[1][0]));
                continue;
            }

            dp[0][0] = board[0][0];
            dp[1][0] = board[1][0];
            dp[0][1] = board[0][1] + board[1][0];
            dp[1][1] = board[1][1] + board[0][0];

            for(int o=2; o<T; o++) {
                dp[0][o] = Math.max(dp[1][o-1], dp[1][o-2]) + board[0][o];
                dp[1][o] = Math.max(dp[0][o-1], dp[0][o-2]) + board[1][o];
            }

            System.out.println(Math.max(dp[0][T-1], dp[1][T-1]));
        }
    }
}
