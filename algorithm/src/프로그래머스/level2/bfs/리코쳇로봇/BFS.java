package 프로그래머스.level2.bfs.리코쳇로봇;

import java.util.*;

class BFS {

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, count;
        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private boolean isValid(int x, int y, int index, char[][] map) {
        int nx = x + dx[index];
        int ny = y + dy[index];
        return nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] != 'D';
    }

    private int bfs(int startX, int startY, int goalX, int goalY, char[][] map, boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();

            if(point.x == goalX && point.y == goalY) {
                return point.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = point.x;
                int ny = point.y;
                while(isValid(nx, ny, i, map)) {
                    nx += dx[i];
                    ny += dy[i];
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, point.count + 1));
                }
            }
        }
        return -1;
    }

    public int solution(String[] board) {
        int startX = 0, startY = 0;
        int goalX = 0, goalY = 0;
        int rows = board.length;
        int cols = board[0].length();
        char[][] map = new char[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        return bfs(startX, startY, goalX, goalY, map, visited);
    }
}
