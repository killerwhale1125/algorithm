package devide_conquer._1992_쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 처음으로 내 힘으로 풀어서 Success한 문제
 */
public class Main {
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

    private static void divide(int X, int Y, int size) {

        if(size == 1){
            sb.append(board[X][Y]);
            return;
        }

        int tmp = board[X][Y];
        boolean all = true;
        for(int i=X; i<X+size; i++) {
            for(int j=Y; j<Y+size; j++) {
                if(board[i][j] != tmp) {
                    all = false;
                    break;
                }
            }
        }

        if(all) {
            sb.append(tmp);
            return;
        } else {
            sb.append("(");
        }

        int mid = size / 2;

        divide(X, Y, mid);
        divide(X, Y + mid, mid);
        divide(X + mid, Y, mid);
        divide(X + mid, Y + mid, mid);

        sb.append(")");
    }
}
