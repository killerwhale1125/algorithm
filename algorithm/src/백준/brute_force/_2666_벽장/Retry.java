package 백준.brute_force._2666_벽장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {
    static int[] useBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int emptyFirst = Integer.parseInt(st.nextToken());
        int emptySecond = Integer.parseInt(st.nextToken());

        int useCount = Integer.parseInt(br.readLine());

        useBoard = new int[useCount];
        for(int i=0; i<useCount; i++) {
            useBoard[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(moveBoard(0, emptyFirst, emptySecond));
    }

    private static int moveBoard(int cnt, int emptyFirst, int emptySecond) {
        if(cnt == useBoard.length) return 0;

        int abs1 = Math.abs(useBoard[cnt] - emptyFirst);
        int abs2 = Math.abs(useBoard[cnt] - emptySecond);

        return Math.min(abs1 + moveBoard(cnt + 1, emptySecond, useBoard[cnt]),
                abs2 + moveBoard(cnt + 1, emptyFirst, useBoard[cnt]));
    }
}
