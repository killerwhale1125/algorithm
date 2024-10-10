package 프로그래머스.level2.bruteforce.전력망을둘로나누기;

import java.util.*;

public class Main {
    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int N;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int answer = -1;
//        int[][] wires = {{1,3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

        int n = 9;
        N = n;
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i=0; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];

            list[x].add(y);
            list[y].add(x);
        }

        searchNode(1);

        System.out.println(min);
    }

    private static void searchNode(int index) {

        for (int x : list[index]) {
            if (visited[x]) {
                bfs(x, index);
                visited[x] = false;
                continue;
            }
            visited[index] = true;
            searchNode(x);
        }

    }

    private static void bfs(int x, int index) {
        boolean[] currentVisited = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        currentVisited[x] = true;
        int count = 1;

        while(!q.isEmpty()) {
            int poll = q.poll();
            currentVisited[poll] = true;

            for(int value : list[poll]) {
                if(value != index && !currentVisited[value]) {
                    q.add(value);
                    count++;
                }
            }
        }

        int abs = Math.abs((N - count) - count);

        min = Math.min(min, abs);
    }
}
