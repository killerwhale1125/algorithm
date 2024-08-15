package 백준.brute_force._2666_벽장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> opens;
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

    static int moveBoard(int cnt, int emptyFirst, int emptySecond) {

        // 더이상 사용할 벽장이 없을 때는 0 반환
        if(cnt == useBoard.length) return 0;

        // 이동한 거리 절댓값
        int abs1 = Math.abs(emptyFirst - useBoard[cnt]);
        int abs2 = Math.abs(emptySecond - useBoard[cnt]);
        
        // 현재 사용했던 벽장이 다음 빈칸의 벽장으로 바뀐다
        return Math.min(
                abs1 + moveBoard(cnt + 1, emptySecond, useBoard[cnt]),
                abs2 + moveBoard(cnt + 1, emptyFirst, useBoard[cnt])
        );
    }
}
