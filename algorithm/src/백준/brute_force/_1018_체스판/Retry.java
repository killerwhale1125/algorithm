package brute_force._1018_체스판;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {
    public static boolean board[][];
    public static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];
        // 배열 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    board[i][j] = true;		// W일 때는 true
                } else {
                    board[i][j] = false;		// B일 때는 false
                }

            }
        }

        int x = N % 8 + 1;
        int y = M % 8 + 1;

        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                checkBoard(i, j);
            }
        }

        System.out.println(min);
    }

    private static void checkBoard(int x, int y) {

        boolean W = board[x][y];
        int count = 0;

        for(int i=x; i<x+8; i++) {
            for(int j=y; j<y+8; j++) {
                if(W != board[x][y]) {
                    count++;
                }

                W = !W;
            }
            W = !W;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);

    }
}
