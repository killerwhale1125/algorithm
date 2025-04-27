package 프로그래머스.pccp;

import java.util.*;

/**
 * 처음 시도 
 * - 각 초마다 현재 로봇들의 위치 값으로 최단거리 (BFS) 탐색하여 count 값으로 경로 결정 후 map에 이동한 위치를 저장
 * 
 * 올바른 시도 
 * - 최단거리가 여러가지일 경우 r 먼저 이동이며, 멘헤튼 거리는 어느곳으로 가든 모두 동일하기 때문에 r 먼저 이동
 * - 각 로봇들이 이동한 거리를 List에 모두 저장하여 Map 형태로 변형
 * - 각 초마다 로봇들의 이동을 비교하며 count를 증가시키며 count > 1 일 경우 충돌 판단
 */
class Solution {
    public int solution(int[][] points, int[][] routes) {
        // 포인트 번호 -> 좌표 매핑
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }

        // 각 로봇별로 시간별 위치 기록
        List<List<int[]>> robotsPaths = new ArrayList<>();
        for (int[] route : routes) {
            List<int[]> path = new ArrayList<>();
            // **출발지 추가**
            int[] start = pointMap.get(route[0]);
            path.add(new int[]{start[0], start[1]});    // [1, 4] 로봇 위치
            for (int i = 0; i < route.length - 1; i++) {
                int[] from = pointMap.get(route[i]);
                int[] to = pointMap.get(route[i + 1]);
                int r1 = from[0];
                int c1 = from[1];
                int r2 = to[0];
                int c2 = to[1];

                // r 먼저 이동
                while (r1 != r2) {
                    if (r1 < r2) r1++;
                    else r1--;
                    path.add(new int[]{r1, c1});
                }
                // c 이동
                while (c1 != c2) {
                    if (c1 < c2) {
                        c1++;
                    } else {
                        c1--;
                    }
                    path.add(new int[]{r1, c1});
                }
            }
            robotsPaths.add(path);
        }

        // 3. 시간별 로봇 위치 기록
        int maxTime = 0;
        for (List<int[]> path : robotsPaths) {
            maxTime = Math.max(maxTime, path.size());
        }
        // 0 ~ maxTime 초까지 각 초마다 로봇들 위치를 Map에 저장 -> 0초에 1,2,3 로봇 ~ 5초에 3번 로봇
        Map<Integer, List<String>> timePos = new HashMap<>();
        for (int idx = 0; idx < robotsPaths.size(); idx++) {
            List<int[]> path = robotsPaths.get(idx);
            for (int t = 0; t < path.size(); t++) {
                int[] pos = path.get(t);
                String key = pos[0] + "," + pos[1];
                timePos.computeIfAbsent(t, k -> new ArrayList<>()).add(key);
            }
        }

        // 1 ~ maxTime 초까지 각 초마다 로봇들의 위치 정보로 새로운 Map에 저장하여 중복된 key(위치) 값이 2개라면 충돌이기 때문에 count 증가
        int dangerCount = 0;
        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> posCounter = new HashMap<>();
            List<String> positions = timePos.getOrDefault(t, new ArrayList<>());
            for (String pos : positions) {
                posCounter.put(pos, posCounter.getOrDefault(pos, 0) + 1);
            }
            for (int count : posCounter.values()) {
                if (count >= 2) {
                    dangerCount++;
                }
            }
        }

        return dangerCount;
    }

    public static void main(String[] args) {
        int[][] points = {
                {3, 2},
                {6, 4},
                {4, 7},
                {1, 4}
        };

        int[][] routes = {
                {4, 2},
                {1, 3},
                {2, 4}
        };

        Solution sol = new Solution();
        int result = sol.solution(points, routes);
        System.out.println(result);  // 기대 결과: 1
    }
}
