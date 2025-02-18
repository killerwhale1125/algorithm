package leetcode.DFS._130;

public class DFS_Optimization {
    private final int[] dx = {-1, 0, 1, 0};  // 상, 우, 하, 좌 방향
    private final int[] dy = {0, 1, 0, -1};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // 엣지에 연결된 'O'들을 찾아서 방문 처리
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0, m, n);  // 첫 열
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1, m, n);  // 마지막 열
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j, m, n);  // 첫 행
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j, m, n);  // 마지막 행
        }

        // 내부 'O'를 'X'로 변환하고, 방문된 'O'는 다시 'O'로 복원
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // 둘러싸인 'O'를 'X'로 변환
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';  // 'T'로 표시된 'O'는 다시 'O'로 복원
                }
            }
        }
    }

    // DFS 탐색: 엣지에 연결된 'O'를 'T'로 표시 (임시로 'O'를 표시하여 방문 처리)
    private void dfs(char[][] board, int x, int y, int m, int n) {
        // 경계 검사 및 조건 확인
        if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'O') {
            return;
        }

        // 현재 'O'를 방문 처리 (임시로 'T'로 바꿈)
        board[x][y] = 'T';

        // 상, 우, 하, 좌로 DFS 진행
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(board, nx, ny, m, n);
        }
    }
}
