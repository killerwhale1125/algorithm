package 프로그래머스.level2.dijkstra.배달;

import java.util.*;

public class BackTracking {
    public static Set<Integer> set = new HashSet<>();
    public static List<ArrayList<Town>> list = new ArrayList<>();
    public static boolean[] visited;
    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        int[][] roads = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 도로 정보 추가
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int length = road[2];

            list.get(a).add(new Town(b, length));
            list.get(b).add(new Town(a, length));
        }

        // 출발 마을 추가
        set.add(1);

        // DFS 탐색
        visited = new boolean[N + 1];
        visited[1] = true;
        for (Town town : list.get(1)) {
            search(town, 0, K);
        }

        System.out.println(set.size());
    }
    private static void search(Town town, int sum, int time) {
        sum += town.road;

        // 시간 초과 조건
        if (sum > time) {
            return;
        }

        // 마을 추가
        set.add(town.number);

        // 탐색
        for (Town nextTown : list.get(town.number)) {
            int num = nextTown.number;
            if (!visited[num]) {
                visited[num] = true;
                search(nextTown, sum, time);
                visited[num] = false;
            }
        }
    }

    static class Town {
        int number;
        int road;

        public Town(int number, int road) {
            this.number = number;
            this.road = road;
        }
    }
}
