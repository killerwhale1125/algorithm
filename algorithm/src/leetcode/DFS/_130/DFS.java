package leetcode.DFS._130;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                List<int[]> idxs = new ArrayList<>();
                if (board[i][j] == 'O' && !visited[i][j] && search(i, j, idxs, board, visited)) {
                    transformX(idxs, board);
                }
            }
        }
    }

    private boolean search(int x, int y, List<int[]> idxs, char[][] board, boolean[][] visited) {

        int m = board.length, n = board[0].length;

        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || board[x][y] == 'X') {
            return true;
        }

        if (x == 0 || y == 0 || x == m - 1 || y == n - 1) {
            return false;  // 가장자리에 닿으면 둘러싸일 수 없음
        }

        visited[x][y] = true;
        idxs.add(new int[]{x, y});
        boolean isSurrounded = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!search(nx, ny, idxs, board, visited)) {
                isSurrounded = false;
            }
        }

        return isSurrounded;
    }

    private void transformX(List<int[]> idxs, char[][] board) {
        for(int[] idx : idxs) {
            board[idx[0]][idx[1]] = 'X';
        }
    }
}
