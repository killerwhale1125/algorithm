package 백준.brute_force._1018_체스판;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Repeat {
    private static boolean[][] board;
    public static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) == 'W' ? true : false;
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                searchBoard(i, j);
            }
        }

        System.out.println(min);
    }

    private static void searchBoard(int x, int y) {
        int count = 0;
        boolean W = board[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if(W != board[i][j]) {
                    count++;
                }

                W = (!W);
            }
            W = !W;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
