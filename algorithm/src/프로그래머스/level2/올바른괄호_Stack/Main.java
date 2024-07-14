package 프로그래머스.level2.올바른괄호_Stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "()()";
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(char x : s.toCharArray()) {
            if(x == '(') {
                stack.push(x);
                continue;
            } else {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }

        if(stack.size() > 0) {
            answer = false;
        }

    }
}
