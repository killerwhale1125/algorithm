package 프로그래머스.level2.stack.뒤에있는큰수찾기;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numbers.length; i++) {

            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        System.out.println(Arrays.toString(answer));
    }
}
