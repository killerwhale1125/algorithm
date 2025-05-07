package 프로그래머스.level2.bfs.지게차와크레인;

import java.util.*;

class Solution {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private boolean isOutOfRange(int x, int y, int N, int M) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    private boolean isNotBlocked(int x, int y, int d, char[][] storage) {
        int N = storage.length;
        int M = storage[0].length;
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] container = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = container[0] + dx[i];
                int ny = container[1] + dy[i];

                if (isOutOfRange(nx, ny, N, M)) return true;

                if (storage[nx][ny] == '#' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return false;
    }

    private boolean isOutside(int x, int y, char[][] storage) {
        int N = storage.length;
        int M = storage[0].length;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isOutOfRange(nx, ny, N, M)) {
                return true;
            }

            if (storage[nx][ny] == '#' && isNotBlocked(nx, ny, i, storage)) {
                return true;
            }
        }
        return false;
    }

    private void takeoutAll(char target, char[][] storage) {
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                if (storage[i][j] == target) {
                    storage[i][j] = '#';
                }
            }
        }
    }

    private void takeoutAll(List<int[]> containers, char[][] storage) {
        for (int[] container : containers) {
            int x = container[0];
            int y = container[1];
            storage[x][y] = '#';
        }
    }

    private void takeout(char target, char[][] storage) {
        List<int[]> containers = new ArrayList<>();

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                if (storage[i][j] == target && isOutside(i, j, storage)) {
                    containers.add(new int[]{i, j});
                }
            }
        }

        takeoutAll(containers, storage);
    }

    public int solution(String[] storage, String[] requests) {
        int N = storage.length;
        int M = storage[0].length();

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = storage[i].toCharArray();
        }

        for (String request : requests) {
            char target = request.charAt(0);
            if (request.length() > 1) {
                takeoutAll(target, map);
            } else {
                takeout(target, map);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '#') {
                    count++;
                }
            }
        }

        System.out.println(Arrays.deepToString(map));
        return count;
    }
}