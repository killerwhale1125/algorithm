package 프로그래머스.level2.dijkstra.배달;

import java.util.*;

public class Dijkstra {
    static class Town {
        int number;
        int road;

        public Town(int number, int road) {
            this.number = number;
            this.road = road;
        }
    }
    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        // 1. 그래프 초기화
        List<List<Town>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 도로 정보 추가 (한 번만 실행!)
        for (int[] r : road) {
            int a = r[0], b = r[1], time = r[2];
            graph.get(a).add(new Town(b, time));
            graph.get(b).add(new Town(a, time));
        }

        // 3. 최단 거리 배열 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;  // 1번 마을 거리 = 0

        // 4. 우선순위 큐 (최소 힙) 사용
        PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.road));
        pq.add(new Town(1, 0));

        while (!pq.isEmpty()) {
            Town curr = pq.poll();
            int node = curr.number;
            int currDist = curr.road;

            if (currDist > dist[node]) continue; // 더 긴 경로 무시

            for (Town next : graph.get(node)) {
                int nextNode = next.number;
                int nextDist = currDist + next.road;

                if (nextDist < dist[nextNode]) {  // 최단 거리 갱신
                    dist[nextNode] = nextDist;
                    pq.add(new Town(nextNode, nextDist));
                }
            }
        }

        // 5. K 이하 거리의 마을 개수 세기
        int count = 0;
        for (int d : dist) {
            if (d <= K) count++;
        }
        System.out.println(count);
    }
}
