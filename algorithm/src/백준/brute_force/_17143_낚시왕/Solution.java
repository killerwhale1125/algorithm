package 백준.brute_force._17143_낚시왕;

import java.util.*;
import java.io.*;

/**
 * 첫 시도 -> 각 초를 List index로 지정하여 내부적으로 2차원 배열 형태로 이동 시기를 기록
 * 장점 -> 직관적
 * 단점 -> 메모리 낭비가 심함
 *
 * 이후 시도 -> 각 초마다 for 순회하며 상어를 배열에서 2동시키며 검증
 * 장점 -> 메모리 낭비 없음
 */
public class Solution {

    static int R, C, M;
    static Shark[][] map;
    static final int[] dx = {0, -1, 1, 0, 0};  // dummy, ↑ ↓ →
    static final int[] dy = {0, 0, 0, 1, -1};

    static class Fisher {
        private int total;

        public Fisher(int total) {
            this.total = total;
        }

        private void fishing(int y) {
            for (int x = 0; x < R; x++) {
                if (map[x][y] != null) {
                    this.total += map[x][y].z;
                    map[x][y] = null;
                    break;
                }
            }
        }
    }

    static class Shark {
        private int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        private void changeDirection() {
            if (d == 1) d = 2;
            else if (d == 2) d = 1;
            else if (d == 3) d = 4;
            else if (d == 4) d = 3;
        }

        private void move() {
            int speed = this.s;
            if (d <= 2) {
                speed %= (R - 1) * 2;
            } else {
                speed %= (C - 1) * 2;
            }

            while (speed > 0) {
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    changeDirection();
                    nx = r + dx[d];
                    ny = c + dy[d];
                }

                r = nx;
                c = ny;
                speed--;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r, c, s, d, z);
        }

        Fisher fisher = new Fisher(0);
        for (int y = 0; y < C; y++) {
            fisher.fishing(y);
            List<Shark> sharks = getAliveShark();
            moveAll(sharks);
        }

        System.out.println(fisher.total);
    }

    private static void moveAll(List<Shark> sharks) {
        for (Shark shark : sharks) {
            shark.move();
            int r = shark.r;
            int c = shark.c;
            int z = shark.z;
            if (map[r][c] == null || map[r][c].z < z) {
                map[r][c] = shark;
            }
        }
    }

    private static List<Shark> getAliveShark() {
        List<Shark> sharks = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != null) {
                    sharks.add(map[r][c]);
                    map[r][c] = null;
                }
            }
        }
        return sharks;
    }
}