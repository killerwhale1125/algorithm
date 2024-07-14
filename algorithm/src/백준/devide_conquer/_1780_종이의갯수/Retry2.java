package 백준.devide_conquer._1780_종이의갯수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Retry2 {
    public static int[][] board;
    public static int minus = 0;
    public static int zero = 0;
    public static int plus = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide_conquer(0, 0, N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void divide_conquer(int x, int y, int size) {
        int check = board[x][y];
        /**
         * Stream 속도 존나 느림
         * 이건 그냥 연습용
         */
        boolean flag = Arrays.stream(board, x, x + size)
                .flatMapToInt(row -> Arrays.stream(row, y, y + size))
                .allMatch(value -> value == check);

        if(flag) {
            switch (check) {
                case -1 :
                    minus++;
                    return;
                case 0 :
                    zero++;
                    return;
                case 1 :
                    plus++;
                    return;
            }
        }

        int mid = size / 3;
        for(int i=x; i<x+size; i+=mid) {
            for(int j=y; j<y+size; j+=mid) {
                divide_conquer(i, j, mid);
            }
        }
    }
}
