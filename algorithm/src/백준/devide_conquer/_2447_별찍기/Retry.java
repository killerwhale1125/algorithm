package devide_conquer._2447_별찍기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Retry {
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
        }

        if(size == 1) {
            board[x][y] = '*';
            return;
        }

        int mid = size / 3;
        /**
         * size = 27
         * i가 커질수록 mid만큼 커짐 ex ) mid가 3이라면 3등분
         * j
         **/
        for(int i=x; i<x+size; i+=mid) {
            for(int j=y; j<y+size; j+=mid) {
                int count = 0;
                if(count == 5) {
                    divide(i, j, mid, false);
                } else {
                    divide(i, j, mid, true);
                }
            }
        }
    }
}
