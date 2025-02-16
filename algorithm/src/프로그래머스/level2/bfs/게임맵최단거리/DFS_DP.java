package 프로그래머스.level2.bfs.게임맵최단거리;

import java.util.*;

/**
 * DFS + DP
 * 1 <= n,m <= 100
 * O(4^n*m) -> 최대 4 ^100 으로 시간 초과
 */
public class DFS_DP {
    private static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] dp; // 최소 거리 저장
    private static int n, m;
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        n = maps.length;
        m = maps[0].length;
        dp = new int[n][m];

        // DP 배열 초기화 (MAX 값으로 설정)
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // DFS 시작 (0,0) → (n-1, m-1)
        dfs(0, 0, 1, maps);

        // 목적지 도착 가능하면 최소 거리 반환, 아니면 -1
        System.out.println(dp[n-1][m-1] == Integer.MAX_VALUE ? -1 : dp[n-1][m-1]);
    }

    private static void dfs(int x, int y, int count, int[][] maps) {
        // 현재 경로가 DP에 저장된 값보다 크면 탐색 중단 (Pruning)
        if (count >= dp[x][y]) return;
        dp[x][y] = count; // 최단 거리 갱신

        // 목표 지점 도달 시 탐색 종료
        if (x == n - 1 && y == m - 1) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 벗어나거나 벽(0)이면 스킵
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx][ny] == 0) {
                continue;
            }

            dfs(nx, ny, count + 1, maps);
        }
    }
}
