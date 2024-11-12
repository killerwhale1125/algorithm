package 프로그래머스.level3.greedy.야근지수;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {4, 3, 3};
        System.out.println(solution(n, works));
    }

    private static long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : works) {
            pq.add(x);
        }

        while(n > 0) {
            int max = pq.poll();

            // 작업이 남아 있지 않거나, 최댓값이 0이면 더 이상 줄일 필요가 없음
            if (max == 0) break;

            // 최대 작업량 감소시키고 다시 큐에 추가
            pq.add(max - 1);
            n--;
        }

        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}
