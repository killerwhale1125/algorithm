package 프로그래머스.level2.greedy.큰수만들기;

import java.util.Stack;

public class Retry {
    public static void main(String[] args) {
        String number = "179252841";
        int k = 6;
        Stack<Character> stack = new Stack<>();
        int length = number.length();

        // k개의 숫자를 제거할 때까지 반복
        for (int i = 0; i < length; i++) {
            char current = number.charAt(i);

            // 스택이 비어있지 않고, 제거할 숫자가 남아있으며, 스택의 top이 현재 숫자보다 작다면 pop
            // k > 0 이 부분이 중요. -> k가 0인데도 pop을하면 자릿수에 맞추지 못하게 됨
            while (!stack.isEmpty() && k > 0 && stack.peek() < current) {
                stack.pop();
                k--;  // 숫자를 하나 제거
            }
            stack.push(current);  // 현재 숫자를 스택에 추가
        }

        // 제거할 숫자가 남아있다면 뒤에서부터 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 스택의 내용을 StringBuilder로 변환하여 결과 반환
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
    }
}
