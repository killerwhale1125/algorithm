package 프로그래머스.level2.kakao.프렌즈4블록;

import java.util.*;

class Solution {
    private int N, M;
    private final int[] dx = {1, 1, 0};
    private final int[] dy = {0, 1, 1};

    private boolean isOutRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    /**
     * i = 0: 'C'
     * i = 1: '.'
     * i = 2: '.'
     * i = 3: 'B'
     * i = 4: 'A'
     * index로 빈칸을 채워야 할 위치를 동적으로 변경
     */
    private void compact(char[][] map) {
        for (int j = 0; j < M; j++) {
            int idx = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (map[i][j] != '.') {
                    map[idx--][j] = map[i][j];
                }
            }
            while (idx >= 0) {
                map[idx--][j] = '.';
            }
        }
    }

    private void remove(Set<String> removes, char[][] map) {
        for (String str : removes) {
            String[] target = str.split(",");
            int x = Integer.parseInt(target[0]);
            int y = Integer.parseInt(target[1]);
            map[x][y] = '.';
        }
    }

    private List<int[]> isBlock(int x, int y, char[][] map) {
        char c = map[x][y];
        List<int[]> list = new ArrayList<>();
        // x + 1, y + 1 범위 안이면 2 X 2 칸 범위 탐색 가능
        if (c == '.' || isOutRange(x + 1, y + 1)) return list;

        list.add(new int[]{x, y});
        for (int d = 0; d < 3; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (map[nx][ny] != c) return Collections.emptyList();
            list.add(new int[]{nx, ny});
        }
        return list;
    }

    private int turn(char[][] map, int n, int m) {
        Set<String> removes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                List<int[]> list = isBlock(i, j, map);
                if (!list.isEmpty()) {
                    for (int[] r : list) {
                        String target = r[0] + "," + r[1];
                        removes.add(target);
                    }
                }
            }
        }

        remove(removes, map);
        compact(map);
        return removes.size();
    }

    public int solution(int n, int m, String[] board) {
        N = n;
        M = m;
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = board[i].toCharArray();
        }

        int answer = 0;
        while (true) {
            int removeSize = turn(map, n, m);
            if (removeSize == 0) break;
            answer += removeSize;
        }

        return answer;
    }
}
