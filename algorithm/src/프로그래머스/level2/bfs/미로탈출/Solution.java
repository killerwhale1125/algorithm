package 프로그래머스.level2.bfs.미로탈출;

import java.util.*;

class Solution {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private char[][] miro;
    private int N, M;

    private boolean isValid(int x, int y, boolean[][] visited) {
        return x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || miro[x][y] == 'X';
    }

    private int bfs(int[] start, boolean[][] visited, boolean flag) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            if (flag && miro[x][y] == 'L') {
                return bfs(cur, new boolean[N][M], false);
            }

            if (!flag && miro[x][y] == 'E') {
                return count;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (isValid(nx, ny, visited)) continue;
                int[] next = {nx, ny, count + 1};
                visited[nx][ny] = true;
                q.add(next);
            }
        }

        return -1;
    }

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        miro = new char[N][M];
        int[] start = new int[3];
        for (int i = 0; i < N; i++) {
            String str = maps[i];
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                miro[i][j] = c;
                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                    start[2] = 0;
                }
            }
        }

        return bfs(start, new boolean[N][M], true);
    }
}