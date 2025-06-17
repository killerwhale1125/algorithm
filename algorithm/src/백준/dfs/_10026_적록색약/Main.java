package 백준.dfs._10026_적록색약;

import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static boolean isOutside(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    private static void integration(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }
    }

    private static void bfs(int x, int y, char[][] board, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        char target = board[x][y];
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (isOutside(nx, ny)) continue;
                if (board[nx][ny] != target) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[N][N];
        int answer1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, board, visited);
                    answer1++;
                }
            }
        }

        integration(board);

        visited = new boolean[N][N];
        int answer2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, board, visited);
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}