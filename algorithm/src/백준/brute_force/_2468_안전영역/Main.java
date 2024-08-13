package 백준.brute_force._2468_안전영역;

import java.io.*;
import java.util.*;

/**
 * 높이를 0부터 탐색해야함
 */
public class Main {
    public static int[][] board;
    public static int N;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int maxCount = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }

        boolean[][] visited;
        // 총 200만번
        for (int i = 0; i <= max; i++) {
            visited = new boolean[N][N];
            initVisitedBoard(i, visited);   // -> 1만번
            int count = 0;
            // 1만번
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if(!visited[x][y]) {
                        visited[x][y] = true;
                        searchSafeArea(x, y, visited);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }

    private static void searchSafeArea(int x, int y, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                visited[nx][ny] = true;
                searchSafeArea(nx, ny, visited);
            }
        }
    }

    public static void initVisitedBoard(int height, boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] <= height) visited[i][j] = true;
            }
        }
    }
}
