package 백준.simulation._14503_로봇청소기;

import java.io.*;
import java.util.*;

public class Solution {
    private static int N, M;
    private static boolean[][] visited;
    private static int[][] map;
    private static int count = 0;

    // 북(0), 동(1), 남(2), 서(3)
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(count);
    }

    private static void clean(int r, int c, int d) {
        if (visited[r][c] == false) {
            visited[r][c] = true;
            count++;
        }

        for (int i = 0; i < 4; i++) {
            /* 반시계 방향 회전 */
            d = (d + 3) % 4;
            int nx = r + dx[d];
            int ny = c + dy[d];
            if (isPossible(nx, ny)) continue;
            clean(nx, ny, d);
            return;
        }

        int back = (d + 2) % 4;
        int bx = r + dx[back];
        int by = c + dy[back];
        if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
            clean(bx, by, d);
        }
    }

    private static boolean isPossible(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 1 || visited[x][y];
    }
}
