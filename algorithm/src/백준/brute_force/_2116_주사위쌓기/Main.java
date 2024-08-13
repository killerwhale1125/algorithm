package 백준.brute_force._2116_주사위쌓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int maxSum = Integer.MIN_VALUE;
    public static int[][] dices;
    public static int N;
    public static int A = 0;
    public static int B = 1;
    public static int C = 2;
    public static int D = 3;
    public static int E = 4;
    public static int F = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        dices = new int[N][6];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // index가 0일 땐 F 이런식
        int nextIndex = 1;
        for(int i=0; i<6; i++) {
            int max = searchMaxNumber(0, getOppositeIndex(i), dices[0][i]);
            stackDices(dices[0][i], nextIndex, max);
            nextIndex = 1;
        }

        System.out.println(maxSum);
    }

    /**
     * @param number 현재값
     * @param nextIndex 다음 인덱스
     * @param sum 합계
     */
    private static void stackDices(int number, int nextIndex, int sum) {

        if(nextIndex == N) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i=0; i<6; i++) {
            if (number == dices[nextIndex][i]) {
                int oppositeIndex = getOppositeIndex(i);
                int max = searchMaxNumber(nextIndex, oppositeIndex, number);
                stackDices(dices[nextIndex][oppositeIndex], nextIndex + 1, sum + max);
            }
        }
    }

    private static int searchMaxNumber(int index, int oppositeIndex, int current) {
        int max = Integer.MIN_VALUE;
        for (int j=0; j<6; j++) {
            if (dices[index][oppositeIndex] != dices[index][j] && dices[index][j] != current) {
                max = Math.max(max, dices[index][j]);
            }
        }
        return max;
    }

    private static int getOppositeIndex(int index) {
        if(index == A) return F;
        if(index == B) return D;
        if(index == C) return E;
        if(index == D) return B;
        if(index == E) return C;
        if(index == F) return A;

        return -1;
    }
}
