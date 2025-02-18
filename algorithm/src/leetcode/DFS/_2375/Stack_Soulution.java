package leetcode.DFS._2375;

import java.util.Stack;

public class Stack_Soulution {
    public String smallestNumber(String pattern) {
        // 결과를 저장할 StringBuilder
        StringBuilder result = new StringBuilder();

        // 스택을 사용하여 숫자 쌓기
        Stack<Integer> stack = new Stack<>();

        int n = pattern.length() + 1;  // 숫자의 개수는 S의 길이 + 1

        for (int i = 1; i <= n; i++) {
            stack.push(i);  // 숫자 i를 스택에 넣음
            System.out.println("push : " + i);
            // 끝에 도달했거나, 'I'인 경우 스택에 있는 숫자들을 꺼냄
            if (i == n || pattern.charAt(i - 1) == 'I') {
                while (!stack.isEmpty()) {
                    System.out.println("pop : " + stack.peek());
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }
}
