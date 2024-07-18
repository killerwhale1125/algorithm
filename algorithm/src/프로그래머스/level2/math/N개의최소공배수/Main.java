package 프로그래머스.level2.math.N개의최소공배수;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        int answer = 0;

        Arrays.sort(arr);
        int limit = arr.length;
        boolean check = Arrays.stream(arr).allMatch(o -> arr[limit - 1] % o == 0);

        int sum = arr[limit - 1];
        for(int i=0; i<limit; i++) {
            sum = sum * arr[i];
            for(int x : arr) {
                if(sum % x != 0) break;
                answer = sum;
            }
        }
    }
}
