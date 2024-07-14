package 백준.brute_force._3085_사탕게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;
    public static char[][] arr;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char currentPoint = arr[i][j];
                for (int k = 0; k < 4; k++) {
                    int width = x[k] + i;
                    int height = y[k] + j;
                    if (width >= 0 && width < N && height >= 0 && height < N) {
                        char changePoint = arr[width][height];
                        arr[i][j] = changePoint;
                        arr[width][height] = currentPoint;

                        checkWidth();
                        checkHeight();
                        arr[i][j] = currentPoint;
                        arr[width][height] = changePoint;
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static void checkWidth() {
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
    }

    private static void checkHeight() {
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (arr[i][j] == arr[i - 1][j]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
    }
}