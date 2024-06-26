package devide_conquer._1780_종이의갯수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {
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

        divide(0, 0, N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void divide(int x, int y, int size) {

        int tmp = board[x][y];
        boolean flag = true;
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(board[i][j] != tmp) {
                    flag = false;
                    break;
                }
            }
        }

        if(flag) {
            switch (tmp) {
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
                divide(i, j, mid);
            }
        }
    }
}
