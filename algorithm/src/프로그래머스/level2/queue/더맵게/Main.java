package 프로그래머스.level2.queue.더맵게;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        int answer = 0;
        int[] scoville = {0, 0};
        int K = 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int x : scoville) {
            queue.add(x);
        }

        while(queue.size() > 1) {
            if(queue.peek() >= K) break;

            int first = queue.poll();
            int second = queue.poll();

            queue.add(first + (second * 2));
            answer++;
        }
        if(!queue.isEmpty() && queue.peek() < K) System.out.println(-1);
        System.out.println(answer);
    }
}
