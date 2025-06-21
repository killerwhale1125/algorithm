package 프로그래머스.pccp._수레움직이기;

public class Solution2 {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private boolean[][][] visited;
    private int[][][] map;
    private final int RED = 0, BLUE = 1;
    private int N, M;
    private int answer = Integer.MAX_VALUE;

    private boolean isValid(int x, int y, int color, int[][] maze) {
        return x < 0 || y < 0 || x >= N || y >= M || visited[color][x][y] || maze[x][y] == 5;
    }

    private void move(int count, int[] red, int[] blue, int[][] maze) {
        int rx = red[0];
        int ry = red[1];
        int bx = blue[0];
        int by = blue[1];

        if (maze[rx][ry] == 3 && maze[bx][by] == 4) {
            answer = Math.min(answer, count);
            return;
        }

        if (answer <= count) {
            return;
        }

        for (int r = 0; r < 4; r++) {
            int rnx = maze[rx][ry] == 3 ? rx : rx + dx[r];
            int rny = maze[rx][ry] == 3 ? ry : ry + dy[r];

            if (maze[rx][ry] != 3 && isValid(rnx, rny, RED, maze)) {
                continue;
            }

            for (int b = 0; b < 4; b++) {
                int bnx = maze[bx][by] == 4 ? bx : bx + dx[b];
                int bny = maze[bx][by] == 4 ? by : by + dy[b];

                if (maze[bx][by] != 4 && isValid(bnx, bny, BLUE, maze)) {
                    continue;
                }

                if ((rnx == bx && rny == by) && (bnx == rx && bny == ry)) continue;
                if (rnx == bnx && rny == bny) continue;

                visited[RED][rnx][rny] = true;
                visited[BLUE][bnx][bny] = true;
                move(count + 1, new int[]{rnx, rny}, new int[]{bnx, bny}, maze);
                visited[RED][rnx][rny] = false;
                visited[BLUE][bnx][bny] = false;
            }
        }
    }

    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        map = new int[2][N][M];
        visited = new boolean[2][N][M];
        int[] red = new int[2];
        int[] blue = new int[2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(maze[i][j] == 1){
                    red[0] = i;
                    red[1] = j;
                }

                if(maze[i][j] == 2){
                    blue[0] = i;
                    blue[1] = j;
                }
            }
        }

        visited[RED][red[0]][red[1]] = true;
        visited[BLUE][blue[0]][blue[1]] = true;
        move(0, red, blue, maze);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
