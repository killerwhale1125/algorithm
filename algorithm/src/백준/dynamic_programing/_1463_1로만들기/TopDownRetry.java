package 백준.dynamic_programing._1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BottomUpRetry {
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        bottomUp(N);
    }

    private static int bottomUp(int X) {
        if(X == 1) {
            return 0;
        }

        int i = bottomUp(X - 1) + 1;

    }
}
