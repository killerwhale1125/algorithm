package 백준.simulation._14499_주사위굴리기;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[] dx = {0, 0, 0, -1, 1};
    private static int[] dy = {0, 1, -1, 0, 0};
    private static final int[][] d = {
            {0, 0, 0, 0, 0, 0},
            {0, 4, 2, 5, 3, 1}, // 동
            {0, 5, 2, 4, 1, 3}, // 서
            {1, 2, 3, 0, 4, 5}, // 북
            {3, 0, 1, 2, 4, 5}};// 남
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] diceD = new int[2];
        diceD[0] = Integer.parseInt(st.nextToken());
        diceD[1] = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[6];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int direction = Integer.parseInt(st.nextToken());
            dice = tumble(diceD, dice, direction);
        }
    }

    // dice 배열 index 3 -> 맨 아래, 1 -> 맨 위
    // x, y 는 현재 주사위가 놓인 칸 위치
    private static int[] tumble(int[] diceD, int[] dice, int direction) {
        int nx = diceD[0] + dx[direction];
        int ny = diceD[1] + dy[direction];

        /* 칸을 벗어날 경우 굴리기 종료 */
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) return dice;

        /* 방향에 따른 주사위 상태 변환 */
        dice = updateDice(dice, direction);

        /* 칸이 0 -> dice index 3 값을 해당 칸에 복사 */
        if (map[nx][ny] == 0) {
            map[nx][ny] = dice[3];

        }
        /* 칸이 0이 아니면 -> 칸에 쓰여진 수가 dice index 3에 복사 후 칸은 0 */
        else {
            dice[3] = map[nx][ny];
            map[nx][ny] = 0;
        }

        diceD[0] = nx;
        diceD[1] = ny;
        System.out.println(dice[1]);
        return dice;
    }

    private static int[] updateDice(int[] dice, int direction) {
        int[] newDice = new int[6];
        for (int i = 0; i < 6; i++) {
            int index = d[direction][i]; // 이 방향으로 이동해야 함
            newDice[index] = dice[i];
        }
        return newDice;
    }
}
