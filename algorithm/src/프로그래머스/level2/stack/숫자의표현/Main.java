package 프로그래머스.level2.stack.숫자의표현;

import java.util.Stack;

/**
 *  주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다
 *  이걸 어케알아
 */
public class Main {
    public static void main(String[] args) {
        int n = 78;
        int answer = 0;
        int next = n + 1;

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            stack.push(n % 2);
            n /= 2;
        }

        int count = countOne(stack, sb);

        stack.clear();

        while(true) {
            sb = new StringBuilder();
            binaryConversion(next, stack);
            if(count == countOne(stack, sb)) {
                answer = next;
                break;
            }
            next++;
            stack.clear();
        }
    }

    public static int countOne(Stack<Integer> stack, StringBuilder sb) {
        int count = 0;

        while(!stack.isEmpty()) {
            if(stack.peek() == 1) {
                count++;
            }
            sb.append(stack.pop());
        }

        return count;
    }

    public static void binaryConversion(int number, Stack<Integer> stack) {
        while(number != 0) {
            stack.push(number % 2);
            number /= 2;
        }
    }
}
