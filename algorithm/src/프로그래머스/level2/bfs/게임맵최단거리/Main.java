package 프로그래머스.level2.bfs.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        int[][] maps = new int[5][5];
        int xLen = maps.length;
        int yLen = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // {x, y, 거리}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            if (x == xLen - 1 && y == yLen - 1) {
//                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < xLen && ny < yLen && maps[nx][ny] != 0) {
                    queue.add(new int[]{nx, ny, dist + 1}); // 큐에 추가
                    maps[nx][ny] = 0;
                }
            }
        }

//        return -1;
    }
}
