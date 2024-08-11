package 프로그래머스.level3.heap.이중우선순위큐;

import java.util.*;

/**
 * PriorityQueue와 Stack을 사용하여 Stack에 최댓값을 저장하는 방식이였지만
 * 이럴 경우 PriorityQueue에서 최솟값을 빼려면 또 이게 문제다.
 * PriorityQueue 두개를 활용하는 방식으로 선택하였다`
 */
public class Main {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;

        for(int i=0;i<operations.length;i++) {
            st = new StringTokenizer(operations[i]);
            char op = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            switch(op) {
                case 'I':
                    min.add(num);
                    max.add(num);
                    break;
                case 'D':
                    if(max.isEmpty()) break;
                    if(num == 1) {
                        int del = max.poll();
                        // O(N)
                        min.remove(del);
                    }
                    if(num == -1) {
                        int del = min.poll();
                        // O(N)
                        max.remove(del);
                    }
            }
        }

        if(max.isEmpty())
            System.out.println(Arrays.toString(new int[] {0, 0}));
        else
            System.out.println(Arrays.toString(new int[] {max.peek(), min.peek()}));
    }
}
