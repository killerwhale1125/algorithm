package 프로그래머스.level2.math.최솟값만들기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {3, 4};
        Arrays.sort(A);
        Arrays.sort(A);

        int sum = 0;
        for(int i=0; i<A.length; i++) {
            sum += A[i] * B[A.length-1-i];
        }
    }
}
