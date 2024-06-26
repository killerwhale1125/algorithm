package devide_conquer._1992_쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {
    public static int[][] board;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        board = new int[N][N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        divide(0, 0, N);
        System.out.println(sb.toString());
    }

    private static void divide(int x, int y, int size) {

        int tmp = board[x][y];
        boolean flag = true;
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(tmp != board[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if(flag) {
            sb.append(tmp);
            return;
        } else {
            sb.append("(");
        }

        int mid = size / 2;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                divide(x + i * mid, y + j * mid, mid);
            }
        }
        sb.append(")");
    }
}
