package 프로그래머스.level2.greedy.호텔대실;

import java.util.*;

class Solution {

    static class Reservation {
        private int start;
        private int end;

        public Reservation(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String[][] book_time) {
        List<Reservation> times = new ArrayList<>();

        for (int i = 0; i < book_time.length; i++) {
            int start = 0;
            int end = 0;
            for (int j = 0; j < book_time[0].length; j++) {
                String[] time = book_time[i][j].split(":");
                int hour = Integer.parseInt(time[0]) * 60;
                int minute = Integer.parseInt(time[1]);
                if (j == 0) {
                    start = hour + minute;
                    continue;
                }
                end = hour + minute;
            }
            times.add(new Reservation(start, end));
        }

        times.sort((t1, t2) -> {
            if (t1.start == t2.start) return t1.end - t2.end;
            return t1.start - t2.start;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int room = 0;
        for (int i = 0; i < times.size(); i++) {
            Reservation r = times.get(i);
            if (!pq.isEmpty() && pq.peek() + 10 <= r.start) {
                pq.poll();
                pq.add(r.end);
                continue;
            }
            pq.add(r.end);
            room++;
        }
        return room;
    }
}