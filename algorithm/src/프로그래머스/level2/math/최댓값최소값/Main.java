package 프로그래머스.level2.math.최댓값최소값;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "1 2 3 4";
        String[] arr = str.split(" ");
        int max = Arrays.stream(arr).mapToInt(Integer::parseInt).max().getAsInt();
        int min = Arrays.stream(arr).mapToInt(Integer::parseInt).min().getAsInt();

        System.out.println(max + " " + min);
    }
}
