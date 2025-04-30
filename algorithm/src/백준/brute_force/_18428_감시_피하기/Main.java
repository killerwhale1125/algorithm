package 백준.brute_force._18428_감시_피하기;

import java.util.*;
import java.io.*;

public class Main {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int N;
    private static char[][] board;
    private static List<int[]> teachers = new ArrayList<>();
    private static String result = "NO";

    private static boolean isDiscover(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            while(true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                if (board[nx][ny] == 'X' || board[nx][ny] == 'T') continue;
                if (board[nx][ny] == 'S') return true; // 학생 발견
                if (board[nx][ny] == 'O') break;
            }
        }

        return false;
    }

    private static void combine(int depth, int start) {
        if (depth == 3) {
            for (int[] teacher : teachers) {
                if (isDiscover(teacher[0], teacher[1])) return;
            }
            result = "YES";
            return;
        }

        for (int i = start; i < N * N; i++) {
            int x = (i - 1) / N;
            int y = (i - 1) % N;
            if (board[x][y] == 'X') {
                board[x][y] = 'O';
                combine(depth + 1, i + 1);
                board[x][y] = 'X';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        StringTokenizer st;
        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < board[i].length; j++) {
                char c = st.nextToken().charAt(0);
                board[i][j] = c;
                if (c == 'T') teachers.add(new int[]{i, j});
            }
        }

        combine(0, 1);
        System.out.println(result);
    }
}