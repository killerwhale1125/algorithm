package 프로그래머스.level2.bfs.지게차와크레인;

import java.util.*;

class Solution3 {
    private int N, M;
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};

    private void crane(char target, char[][] storage) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (target == storage[i][j]) {
                    storage[i][j] = '#';
                }
            }
        }
    }

    private void remove(List<int[]> containers, char[][] storage) {
        for (int[] container : containers) {
            int x = container[0];
            int y = container[1];
            storage[x][y] = '#';
        }
    }

    private boolean isOutside(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    private boolean isTakeOut(int x, int y, char[][] storage) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (isOutside(nx, ny)) return true;
                if (visited[nx][ny]) continue;
                if (storage[nx][ny] != '#') continue;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        return false;
    }

    private void takeOut(char target, char[][] storage) {
        List<int[]> containers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (target == storage[i][j]) {
                    if (isTakeOut(i, j, storage)) {
                        containers.add(new int[]{i, j});
                    }
                }
            }
        }

        remove(containers, storage);
    }

    public int solution(String[] s, String[] requests) {
        N = s.length;
        M = s[0].length();
        char[][] storage = new char[N][M];
        for (int i = 0; i < N; i++) {
            storage[i] = s[i].toCharArray();
        }

        for (String req : requests) {
            char target = req.charAt(0);
            if (req.length() > 1) {
                crane(target, storage);
                continue;
            }
            takeOut(target, storage);
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (storage[i][j] != '#') {
                    count++;
                }
            }
        }
        return count;
    }
}