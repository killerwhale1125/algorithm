package 백준.brute_force._17136_색종이붙이기;

import java.util.Scanner;

public class Solution {
    static int[][] map = new int[10][10];      // 10x10 종이 지도
    static int[] paper = {0, 5, 5, 5, 5, 5};    // 색종이 크기별 사용 가능 개수 (1~5, 인덱스 맞추기 위해 0은 무시)
    static int min = Integer.MAX_VALUE;        // 색종이 최소 사용 개수 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 10x10 종이 정보 입력 받기 (1: 덮어야 할 곳, 0: 이미 비어있음)
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                map[i][j] = sc.nextInt();

        // 백트래킹 시작
        dfs(0, 0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void dfs(int x, int y, int cnt) {
        if (cnt >= min) return;

        if (x >= 10) {
            min = Math.min(min, cnt);
            return;
        }

        if (y >= 10) {
            dfs(x + 1, 0, cnt);
            return;
        }

        if (map[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (paper[size] > 0 && canAttach(x, y, size)) {
                    paper[size]--;
                    attach(x, y, size, 0);
                    dfs(x, y + 1, cnt + 1);
                    paper[size]++;
                    attach(x, y, size, 1);
                }
            }
        }
        else {
            dfs(x, y + 1, cnt);
        }
    }

    private static void attach(int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = value;
            }
        }
    }

    private static boolean canAttach(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) return false;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }
}
