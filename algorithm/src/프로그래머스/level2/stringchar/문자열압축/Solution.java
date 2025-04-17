package 프로그래머스.level2.stringchar.문자열압축;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("abcabcdede"));
    }

    private static boolean isNotEmpty(Stack<String> stack) {
        return !stack.isEmpty();
    }

    private static boolean isNotEqualsToken(String token, String peek) {
        return !token.equals(peek);
    }

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;


        /* 1부터 n 까지 비교*/
        for (int offset = 1; offset <= s.length(); offset++) {  // 1 ~ 10
            StringBuilder builder = new StringBuilder();
            Stack<String> stack = new Stack<>();

            for (int start = 0; start <= s.length() - 1; start += offset) {
                int end = Math.min(start + offset, s.length());
                String token = s.substring(start, end);

                if (isNotEmpty(stack) && isNotEqualsToken(token, stack.peek())) {
                    int size = stack.size();
                    String compression = (size > 1 ? size : "") + stack.pop();
                    stack.clear();
                    builder.append(compression);
                }

                stack.push(token);
            }

            if (!stack.isEmpty()) {
                int size = stack.size();
                String compression = (size > 1 ? size : "") + stack.pop();
                builder.append(compression);
            }

            min = Math.min(min, builder.toString().length());
        }

        return min;
    }
}
