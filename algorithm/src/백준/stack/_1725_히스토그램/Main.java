package stack._1725_히스토그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;

        while (i < N) {
            // 스택이 비어있거나 현재 높이가 스택의 top보다 크면 push
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                // 현재 높이가 스택의 top보다 작으면 pop
                int top = stack.pop();
                // 높이
                int height = heights[top];
                // 너비 계산
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // 최대 면적 계산
                maxArea = Math.max(maxArea, height * width);
            }
        }

        // 남아 있는 스택 처리
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int height = heights[top];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        System.out.println(maxArea);
    }
}
