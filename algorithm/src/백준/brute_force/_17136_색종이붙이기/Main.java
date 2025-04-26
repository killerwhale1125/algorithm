package 백준.brute_force._17136_색종이붙이기;

import java.util.Scanner;

public class Main {
    static int[][] map = new int[10][10];      // 10x10 종이 지도
    static int[] paper = {0, 5, 5, 5, 5, 5};    // 색종이 크기별 사용 가능 개수 (1~5, 인덱스 맞추기 위해 0은 무시)
    static int min = Integer.MAX_VALUE;        // 색종이 최소 사용 개수 저장

    /**
     * 백트래킹 DFS 함수
     * @param x 현재 행
     * @param y 현재 열
     * @param cnt 지금까지 사용한 색종이 수
     */
    static void dfs(int x, int y, int cnt) {
        // 종료 조건: 맵 끝까지 탐색했을 경우
        if (x >= 10) {
            min = Math.min(min, cnt);  // 최소값 갱신
            return;
        }

        // 가지치기: 현재까지 사용한 색종이 수가 이미 최소값 이상이면 더 볼 필요 없음
        if (cnt >= min) return;

        // 다음 줄로 넘어감
        if (y >= 10) {
            dfs(x + 1, 0, cnt);
            return;
        }

        // 덮어야 할 위치인 경우
        if (map[x][y] == 1) {
            // 5x5부터 1x1까지 가능한 모든 색종이 크기 시도
            for (int size = 5; size >= 1; size--) {
                // 해당 크기 색종이를 사용할 수 있고, 붙일 수 있는 경우
                if (paper[size] > 0 && canAttach(x, y, size)) {
                    attach(x, y, size, 0);    // 색종이 붙이기 (1 → 0으로 변경)
                    paper[size]--;           // 색종이 사용 처리
                    dfs(x, y + 1, cnt + 1);  // 다음 열로 진행
                    attach(x, y, size, 1);    // 원상복구
                    paper[size]++;           // 색종이 되돌리기
                }
            }
        } else {
            // 이미 0이라 덮을 필요 없으면 그냥 다음 칸으로 이동
            dfs(x, y + 1, cnt);
        }
    }

    /**
     * (x, y) 위치에 size 크기의 색종이를 붙일 수 있는지 확인
     */
    static boolean canAttach(int x, int y, int size) {
        // 범위를 벗어나면 불가능
        if (x + size > 10 || y + size > 10) return false;

        // 색종이 영역 내에 모두 1이어야만 붙일 수 있음
        for (int i = x; i < x + size; i++)
            for (int j = y; j < y + size; j++)
                if (map[i][j] != 1) return false;

        return true;
    }

    /**
     * 색종이를 붙이거나 떼는 함수
     * @param val 0이면 색종이 붙임 (덮기), 1이면 되돌리기 (되살림)
     */
    static void attach(int x, int y, int size, int val) {
        for (int i = x; i < x + size; i++)
            for (int j = y; j < y + size; j++)
                map[i][j] = val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 10x10 종이 정보 입력 받기 (1: 덮어야 할 곳, 0: 이미 비어있음)
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                map[i][j] = sc.nextInt();

        // 백트래킹 시작
        dfs(0, 0, 0);

        // 결과 출력 (불가능한 경우는 -1)
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
