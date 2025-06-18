package 백준.bfs.탈출;

import java.io.*;
import java.util.*;

/**
 1. 물 퍼짐을 먼저 water 배열에 시간 기록 ( BFS )
 2. 고슴도치가 BFS로 water 시간보다 작을 경우에만 이동 가능

 반례
 5 5
 DX.*.
 .X...
 .X..*
 .X...
 SX...
 */
public class BFS {
    private static int N, M;
    private static int[] S;
    private static char[][] map;
    private static int[][] water;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static boolean isOutside(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    private static int move(int x, int y, boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        visited[S[0]][S[1]] = true;
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] beaver = q.poll();
            int bx = beaver[0];
            int by = beaver[1];
            int minute = beaver[2];

            if (map[bx][by] == 'D') return minute;

            for (int d = 0; d < 4; d++) {
                int nx = bx + dx[d];
                int ny = by + dy[d];

                if (isOutside(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'X') continue;
                /**
                 * water[nx][ny] == -1 -> 물이 닿지 않은 곳
                 * water[nx][ny] > minute + 1 -> 현재 기록된 시간이 물 기록보다 작을 때 이동 가능
                 */
                boolean waterOK = (water[nx][ny] == -1 || water[nx][ny] > minute + 1);

                if (map[nx][ny] == 'D' || waterOK) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, minute + 1});
                }
            }
        }

        return -1;
    }

    // 물이 흘러간 시간을 배열에 기록
    private static void waterFlow(Queue<int[]> waterQ, boolean[][] visited) {
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
        for (int i = 0; i < N; i++) {
            Arrays.fill(water[i], -1); // 물이 닿지 않은 곳은 -1로 초기화
        }
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> waterQ = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
                if (map[i][j] == 'S') S = new int[]{i, j};
                if (map[i][j] == '*') {
                    waterQ.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                    water[i][j] = 0;    // 명시적 선언
                }
            }
        }

        waterFlow(waterQ, visited);
        int result = move(S[0], S[1], new boolean[N][M]);
        System.out.println(result == -1 ? "KAKTUS" : result);
    }
}

