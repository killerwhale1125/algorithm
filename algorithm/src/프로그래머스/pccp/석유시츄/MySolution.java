package 프로그래머스.pccp.석유시츄;

import java.util.*;

class MySolution {
    private int n, m;
    private final int[] dy = {-1, 1, 0, 0};
    private final int[] dx = {0, 0, -1, 1};

    private boolean isNotInRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }

    private int count(int x, int y, int groupId, int[][] land, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        int count = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (isNotInRange(nx, ny)) continue;
                if (land[nx][ny] == 0) continue;
                if (visited[nx][ny] != -1) continue;

                visited[nx][ny] = groupId;
                q.add(new int[]{nx, ny});
                count++;
            }
        }

        return count;
    }

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;

        int[][] visited = new int[n][m];
        for (int[] v : visited) {
            Arrays.fill(v, -1);
        }

        int groupId = 0;
        Map<Integer, Integer> groupsCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == -1 && land[i][j] == 1) {
                    visited[i][j] = groupId;
                    groupsCount.put(groupId, count(i, j, groupId, land, visited));
                    groupId++;
                }
            }
        }

        // <y-index, Set<groupId>>
        Map<Integer, Set<Integer>> setMap = new HashMap<>();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (visited[x][y] != -1) {
                    setMap.computeIfAbsent(y, k -> new HashSet<>())
                            .add(visited[x][y]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (Set<Integer> groupIds : setMap.values()) {
            int sum = 0;
            for (int id : groupIds) {
                sum += groupsCount.get(id);
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}