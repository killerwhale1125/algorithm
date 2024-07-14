package 백준.brute_force._3085_사탕게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Retry {
    private static char[][] board;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int N;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<4; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                char point = board[i][j];
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        char nextPoint = board[nx][ny];
                        board[nx][ny] = point;
                        board[i][j] = nextPoint;

                        widthCheck();
                        heightCheck();
                        board[nx][ny] = nextPoint;
                        board[i][j] = point;
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static void heightCheck() {
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
    }

    private static void widthCheck() {
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
    }
}
