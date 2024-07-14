package 백준.brute_force._14500_테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {
    public static int N;
    public static int M;
    public static boolean[][] visited;
    public static int[][] board;
    public static int max = Integer.MIN_VALUE;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        board = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * DFS 탐색
         */
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited[i][j] = true;
                DFS(i, j, 1, board[i][j]);
                max = Math.max(max, searchTetromior(i, j, 0, board[i][j]));
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static int searchTetromior(int x, int y, int count, int sum) {
        int min = Integer.MAX_VALUE;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                sum += board[nx][ny];
                min = Math.min(min, board[nx][ny]);
                count++;
            }
        }

        if(count == 3) {
            return sum;
        } else if(count == 4) {
            return sum - min;
        } else {
            return -1;
        }
    }

    private static void DFS(int x, int y, int count, int sum) {
        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                DFS(nx, ny, count+1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
}
