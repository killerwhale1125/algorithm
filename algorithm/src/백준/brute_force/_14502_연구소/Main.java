package 백준.brute_force._14502_연구소;

import java.io.*;
import java.util.*;

/**
 * 깊은 복사 ( 완전히 새로이 복사 )
 * 얕은 복사 ( 참조 -> 값이 바뀌면 다바뀜 )
 * 이 문제로 인하여 max값이 자꾸 0으로 나옴
 *
 * 1. 전체 board에서 0을 1로 3개만 바꾼다.
 * 2. 1을 3개로 바꿨을 때 바이러스를 전파시킨다.
 * 3. 0의 갯수를 max에 저장하여 비교한다.
 */
public class Main {
    public static int N;
    public static int M;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] board;
    public static int[][] cloneBoard;
    public static int max = Integer.MIN_VALUE;
    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);
        System.out.println(max);
    }

    private static void buildWall(int count) {
        if(count == 3) {
            contagionVirus();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    buildWall(count + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static void contagionVirus() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        cloneBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            cloneBoard[i] = board[i].clone();
        }

        while(!q.isEmpty()) {
            int[] virus = q.poll();

            for(int i=0; i<4; i++) {
                int nx = dx[i] + virus[0];
                int ny = dy[i] + virus[1];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && cloneBoard[nx][ny] == 0) {
                    cloneBoard[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        max = Math.max(max, countSafeZone());
    }

    private static int countSafeZone() {
        return (int) Arrays.stream(cloneBoard)
                .flatMapToInt(Arrays::stream)
                .filter(num -> num == 0)
                .count();
    }
}
