package devide_conquer._1780_종이의갯수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] board;
    public static int zero;
    public static int minus;
    public static int plus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide_board(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void divide_board(int x, int y, int size) {
        int point = board[x][y];
        boolean flag = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (point != board[i][j]) {
                    flag = false;
                }
            }
        }

        if (flag) {
            if (board[x][y] == -1) {
                minus++;
            } else if (board[x][y] == 0) {
                zero++;
            } else {
                plus++;
            }
            return;
        }

        // false일 경우 9개로 분할
        int divide_size = size / 3;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                divide_board(x + i * divide_size, y + j * divide_size, divide_size);
    }
}
