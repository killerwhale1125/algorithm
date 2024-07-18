package 프로그래머스.level2.stack.짝지어제거하기;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "abbcc";
        int answer = 1;

        Stack<Character> stack = new Stack<>();

        for(char x : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(x);
                continue;
            }

            if(stack.peek() == x) {
                stack.pop();
            } else {
                stack.push(x);
            }
        }

        if(!stack.isEmpty()) {
            answer = 0;
        }
    }
}
