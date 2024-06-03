package brute_force._14500_테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FailAndReview {
    public static boolean[][] visited;
    public static int[][] arr;
    public static int[] nx = {-1, 0, 1, 0};
    public static int[] ny = {0, 1, 0, -1};
    public static int N;
    public static int M;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited[i][j] = true;
                DFS(i, j, 1, arr[i][j]);
                max = Math.max(max, getLast(i, j));
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static int getLast(int x, int y) {
        int sum = arr[x][y];
        int count = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<4; i++) {
            int dx = x + nx[i];
            int dy = y + ny[i];
            if(dx >= 0 && dx < N && dy >= 0 && dy < M) {
                count++;
                sum += arr[dx][dy];
                min = Math.min(min, arr[dx][dy]);
            }
        }

        if(count == 4) {
            return sum - min;
        } else if(count == 3) {
            return sum;
        } else {
            return -1;
        }
    }

    static void DFS(int x, int y, int count, int sum) {
        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int dx = x + nx[i];
            int dy = y + ny[i];

            if(dx >= 0 && dx < N && dy >= 0 && dy < M && !visited[dx][dy]) {
                visited[dx][dy] = true;
                DFS(dx, dy, count+1, sum + arr[dx][dy]);
                visited[dx][dy] = false;
            }
        }
    }
}
