package 프로그래머스.level2.stack.주식가격;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] prices = {4, 5, 6, 7, 1, 1};
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            /**
             * prices[i] < prices[stack.peek() 현재 넣으려는 값보다 Stack에 있는 값이 크다는 뜻은
             * Stack에 있는 값은 이제 떨어질 값이라는 의미
             * 
             * answer[stack.peek()] = i - stack.peek(); 하고 pop을 하는 이유
             * Stack에 들어가는 데이터는 증가하는 값만 들어가는데
             * 현재 집어넣으려는 값보다 큰 값은 무조건 현재 시점에서 처음 떨어지는 값들이기 때문에 
             * answer[stack.peek()] = i - stack.peek(); -> 현재 시점을 기준으로 index로 그 사이의 거리를 넣어준다
             */
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        System.out.println(Arrays.toString(answer));
    }
}
