package 백준.brute_force._15683_감시;

import java.util.*;
import java.io.*;

public class Main {

    static class CCTV {
        private int id;
        private int x;
        private int y;

        public CCTV(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final Map<Integer, int[][]> dMap = Map.of(
            1, new int[][]{{0}, {1}, {2}, {3}},
            2, new int[][]{{0, 2}, {1, 3}},
            3, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            4, new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            5, new int[][]{{0, 1, 2, 3}}
    );
    private static final Map<String, Integer> resultMap = new HashMap<>();
    private static List<CCTV> cctvs = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;
    private static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if (num !=0 && num != 6) {
                    cctvs.add(new CCTV(num, i, j));
                }
            }
        }

        dfs(0, board);
        System.out.println(min);
    }

    private static void dfs(int depth, int[][] board) {
        if (depth == cctvs.size()) {
            min = Math.min(min, count(board));
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int cctvId = cctv.id;
        int x = cctv.x;
        int y = cctv.y;

        for (int[] directions : dMap.get(cctvId)) {
            int[][] copiedBoard = copy(board);

            for (int dir : directions) {
                monitor(x, y, dir, copiedBoard);
            }

            dfs(depth + 1, copiedBoard);
        }
    }

    private static void monitor(int x, int y, int dir, int[][] board) {
        int nx = x;
        int ny = y;

        while(true) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 6) break;

            if (board[nx][ny] == 0) {
                board[nx][ny] = 7;
            }
        }
    }

    private static int[][] copy(int[][] board) {
        int[][] newBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }

    private static int count(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}