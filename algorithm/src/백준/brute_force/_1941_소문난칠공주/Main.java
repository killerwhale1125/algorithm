package 백준.brute_force._1941_소문난칠공주;

import java.util.*;
import java.io.*;

public class Main {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final char[][] map = new char[5][5];
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 25개 중 7개 조합을 백트래킹
        combine(0, 0, 0, new ArrayList<>());
        System.out.println(answer);
    }

    private static void combine(int start, int depth, int sCount, List<Integer> selected) {
        /* 가지 치기 -> Y가 3명 이상일 경우 */
        if (selected.size() - sCount > 3) return;

        if (depth == 7) {
            if (isConnected(selected)) {
                answer++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            selected.add(i);
            int x = i / 5;
            int y = i % 5;
            combine(i + 1, depth + 1, map[x][y] == 'S' ? sCount + 1 : sCount, selected);
            selected.remove(selected.size() - 1);
        }
    }

    private static boolean isConnected(List<Integer> selected) {
        boolean[] visited = new boolean[25];
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> selectedSet = new HashSet<>(selected);

        q.add(selected.get(0));
        visited[selected.get(0)] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int pos = q.poll();
            int x = pos / 5;
            int y = pos % 5;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int next = nx * 5 + ny; // 1차원 배열의 index 값으로 변환

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (!selectedSet.contains(next) || visited[next]) continue;

                visited[next] = true;
                count++;
                q.add(next);
            }
        }

        return count == 7;
    }
}