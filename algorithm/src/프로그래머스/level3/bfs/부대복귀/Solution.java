package 프로그래머스.level3.bfs.부대복귀;

import java.util.*;

class Solution {

    // BFS 탐색
    private int[] bfs(int start, List<List<Integer>> map) {
        int[] record = new int[map.size()];
        Arrays.fill(record, -1);
        record[start] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int index = node[0];
            int count = node[1];

            for (int next : map.get(index)) {
                if (record[next] != -1) continue;
                record[next] = count + 1;
                q.add(new int[]{next, count + 1});
            }
        }

        return record;
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int r1 = roads[i][0];
            int r2 = roads[i][1];
            map.get(r1).add(r2);
            map.get(r2).add(r1);
        }

        int[] result = bfs(destination, map);
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = result[sources[i]];
        }
        return answer;
    }
}