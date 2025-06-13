package 프로그래머스.level2.bfs.게임맵최단거리;

import java.util.*;

class Solution {
    private int N, M;
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};

    private boolean isOutside(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    private int bfs(int[][] maps, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int count = cur[2];
            if (cur[0] == N - 1 && cur[1] == M - 1) return count;

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (isOutside(nx, ny)) continue;
                if (maps[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                q.add(new int[]{nx, ny, count + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }

    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        return bfs(maps, visited);
    }
}