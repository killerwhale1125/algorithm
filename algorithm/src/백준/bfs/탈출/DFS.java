package 백준.bfs.탈출;

import java.util.*;
import java.io.*;

/**
 1. 물 퍼짐을 먼저 water 배열에 시간 기록 ( BFS )
 2. 고슴도치가 DFS 돌며 water 시간보다 작을 경우에만 이동 가능
 */
public class DFS {
    private static int N, M;
    private static int min = Integer.MAX_VALUE;
    private static int[] S;
    private static char[][] map;
    private static int[][] water;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static boolean isOutside(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    private static void move(int minute, int x, int y, boolean[][] visited) {

        if (map[x][y] == 'D') {
            min = Math.min(min, minute);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isOutside(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 'X') continue;
            // 현재 문제는 water가 0이여서 무조건 continue된다.
            if (map[nx][ny] != 'D' && water[nx][ny] <= minute + 1) continue;

            visited[nx][ny] = true;
            move(minute + 1, nx, ny, visited);
            visited[nx][ny] = false;
        }
    }

    // 물이 흘러간 시간을 배열에 기록
    private static void waterFlow(Queue<int[]> waterQ) {
        boolean[][] visited = new boolean[N][M];
        while (!waterQ.isEmpty()) {
            int[] w = waterQ.poll();
            int minute = w[2];
            for (int d = 0; d < 4; d++) {
                int nx = w[0] + dx[d];
                int ny = w[1] + dy[d];

                if (isOutside(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;

                visited[nx][ny] = true;
                waterQ.add(new int[]{nx, ny, minute + 1});
                water[nx][ny] = minute + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        water = new int[N][M];
        Queue<int[]> waterQ = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
                if (map[i][j] == 'S') S = new int[]{i, j};
                if (map[i][j] == '*') {
                    waterQ.add(new int[]{i, j, 0});
                    water[i][j] = 0;    // 명시적 선언
                }
            }
        }

        waterFlow(waterQ);
        boolean[][] visited = new boolean[N][M];
        visited[S[0]][S[1]] = true;
        move(0, S[0], S[1], visited);
        System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);
    }
}

