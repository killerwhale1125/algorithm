package devide_conquer._2447_별찍기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new char[N][N];

        divide(0, 0, N, true);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void divide(int x, int y, int size, boolean flag) {

        if(!flag) {
            for(int i=x; i<x+size; i++) {
                for(int j=y; j<y+size; j++) {
                    board[x][y] = ' ';
                }
            }
            return;
        }

        if(size == 1) {
            board[x][y] = '*';
            return;
        }

        int mid = size / 3;

        int count = 0;
        for(int i=x; i<x+size; i+=mid) {
            for(int j=y; j<y+size; j+=mid) {
                count++;
                if(count == 5) {
                    divide(i, j, mid, false);
                } else {
                    divide(i, j, mid, true);
                }
            }
        }
    }
}
