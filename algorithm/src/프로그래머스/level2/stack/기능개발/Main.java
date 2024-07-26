package 프로그래머스.level2.stack.기능개발;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        List<Task> list = new ArrayList<>();
        for(int i=0; i<progresses.length; i++) {
            list.add(new Task(progresses[i], speeds[i]));
        }
        List<Integer> resultList = new ArrayList<>();

        // 스택에 남은 일수를 저장
        Queue<Integer> queue = new LinkedList<>();

        for(Task task : list) {
            int remainingPeriod = 100 - task.progress;
            int speed = task.speed;
            int period = remainingPeriod % speed == 0 ?
                    remainingPeriod / speed : remainingPeriod / speed + 1;

            if(!queue.isEmpty()) {
                int queuePeriod = queue.peek();
                if(period > queuePeriod) {
                    resultList.add(queue.size());
                    queue.clear();
                }
            }

            queue.add(period);
        }
        if(!queue.isEmpty()) {
            resultList.add(queue.size());
        }
        int[] answer = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }

    static class Task {
        int progress;
        int speed;

        public Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }
}
