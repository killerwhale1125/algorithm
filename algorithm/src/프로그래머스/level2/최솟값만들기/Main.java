package 프로그래머스.최솟값만들기;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {3, 4};
        Arrays.sort(A);
        B = Arrays.stream(B)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        
    }
}
