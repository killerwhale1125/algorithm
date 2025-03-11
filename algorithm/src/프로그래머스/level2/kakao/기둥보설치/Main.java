package 프로그래머스.level2.kakao.기둥보설치;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static int[][] board;
    public static final int NONE = 0;
    public static final int PILLAR = 1;
    public static final int BO = 2;
    public static void main(String[] args) {
        int n = 5;
//        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3, 2, 1, 1}};
        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        board = new int[n + 1][n + 1];

        for(int i=0; i<build_frame.length; i++) {
            int y = build_frame[i][0];
            int x = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if (a == 0) {
                if(checkPillar(x, y, b)) {
                    operation(x, y, b, PILLAR);
                }
            } else {
                if(checkBo(x, y, b)) {
                    operation(x, y, b, BO);
                }
            }
    }
    List<int[]> list = new ArrayList<>();

    for(int i=0; i<board.length; i++) {
        for(int j=0; j<board[i].length; j++) {
            if(board[i][j] != NONE) {
                list.add(new int[] {j, i, board[i][j] == PILLAR ? 0 : 1});
            }
        }
    }

    int[][] answer = list.stream().sorted(Comparator.comparingInt((int[] arr) -> arr[0]) // x 좌표 기준 오름차순
                    .thenComparingInt(arr -> arr[1])) // 값이 같으면 y 좌표 기준 오름차순
            .toArray(int[][]::new);
    System.out.println(Arrays.deepToString(answer));
}

    public static boolean checkPillar(int x, int y, int b) {
        if (b == 0) {
            if(board[x+1][y] == NONE) return true;
            if(board[x + 1][y - 1] == BO && board[x + 1][y] == BO) return true;
            if(board[x][y - 1] == PILLAR) return true;
            if(board[x][y + 1] == PILLAR) return true;
        }
        else {
            if (x == 0 && y >= 0 && y < board.length) return true;
            if (board[x-1][y] == PILLAR || board[x][y-1] == BO || board[x][y+1] == BO) return true;
        }
        return false;
    }

    public static boolean checkBo(int x, int y, int b) {
        if (b == 0) {

        }
        else {
            // 아래 기둥이 있는지? 오른쪽 끝이라면 추가 불가 [1 1 0 1] 에서 막힘
            if(board[x - 1][y] == PILLAR || board[x-1][y + 1] == PILLAR && y < board.length-1) {
                return true;
            }

            if(board[x][y-1] == BO && board[x][y+1] == BO) return true;
        }

        return false;
    }

    private static void operation(int x, int y, int b, int kind) {
        if (b == 0) remove(x, y);
        else add(x, y, kind);
    }

    private static void remove(int x, int y) {
        board[x][y] = NONE;
    }

    public static void add(int x, int y, int kind) {
        board[x][y] = kind;
    }

}
