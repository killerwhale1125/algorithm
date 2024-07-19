package 프로그래머스.level2.list.연속부분수열합의갯수;

import java.util.HashSet;
import java.util.Set;

/**
 * 핵심 -> j % elements.length 나누기를 이용하여 위치를 계산
 */
public class OtherCode {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        Set<Integer> set = new HashSet<>();

        int start = 1;
        while (start <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int value = 0;
                for (int j = i; j < i + start; j++) {
                    value += elements[j % elements.length];
                }
                set.add(value);
            }
            start++;
        }
    }
}
