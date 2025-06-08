package 프로그래머스.level2.stack.택배상자;

import java.util.Stack;

/**
 * while 로 넣을 수 있는 상자는 넣은 후 다음 값 검증 부분에서 틀림
 */

class Solution {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int index = 0;
        int count = 0;
        for (int i = 1; i <= order.length; i++) {
            sub.push(i);

            while (!sub.isEmpty() && sub.peek() == order[index]) {
                sub.pop();
                index++;
                count++;
            }
        }

        return count;
    }
}