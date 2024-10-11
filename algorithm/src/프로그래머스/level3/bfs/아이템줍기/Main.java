package 프로그래머스.level3.bfs.아이템줍기;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 풀이 : https://siino.tistory.com/23
 */

public class Main {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
//        int[][] rectangle = {{1, 1, 5, 7}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        // 좌표계 확장을 위해 2배로 키운다.
        int[][] map = new int[101][101];

        for(int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            for(int i=x1; i<=x2; i++) {
                for(int j=y1; j<=y2; j++) {
                    if(i == x1 || i == x2 || j == y1 || j == y2) {
                        if (map[i][j] != 2) map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }

        bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    private static int bfs(int[][] map, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});  // 시작 좌표와 이동 거리를 저장
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 아이템 위치에 도착하면 거리를 반환
            if (x == endX && y == endY) {
                return distance / 2;  // 2배 확장했으므로 나누기 2를 해야 원래 거리
            }

            // 상, 하, 좌, 우로 이동하면서 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵을 벗어나지 않고, 테두리(1)인 경우에만 이동
                if (nx >= 0 && ny >= 0 && nx <= 100 && ny <= 100 && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }
}
