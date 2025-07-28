package 프로그래머스.pccp.로봇_충돌_위험;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    private final Map<Integer, int[]> pointMap = new HashMap<>();

    private void initPointMap(int[][] points) {
        for (int i = 1; i <= points.length; i++) {
            pointMap.put(i, points[i - 1]);
        }
    }

    private void moveAndRecord(int[] route, Map<String, Integer> visitCount) {
        int[] curr = Arrays.copyOf(pointMap.get(route[0]), 2);
        int turn = 1;

        for (int i = 1; i < route.length; i++) {
            int[] dest = pointMap.get(route[i]);

            while (curr[0] != dest[0] || curr[1] != dest[1]) {
                String record = turn + "," + curr[0] + "," + curr[1];
                visitCount.put(record, visitCount.getOrDefault(record, 0) + 1);
                turn++;

                if (curr[0] != dest[0]) {
                    curr[0] += (curr[0] < dest[0]) ? 1 : -1;
                } else {
                    curr[1] += (curr[1] < dest[1]) ? 1 : -1;
                }
            }
        }

        // 마지막 좌표 기록
        String record = turn + "," + curr[0] + "," + curr[1];
        visitCount.put(record, visitCount.getOrDefault(record, 0) + 1);
    }

    public int solution(int[][] points, int[][] routes) {
        Map<String, Integer> visitCount = new HashMap<>();
        initPointMap(points);

        for (int[] route : routes) {
            moveAndRecord(route, visitCount);
        }

        int answer = 0;
        for (int count : visitCount.values()) {
            if (count > 1) answer++;
        }

        return answer;
    }
}
