package 백준.brute_force._15686번_치킨배달;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Retry {
    static int N, LIMIT;
    static int[][] graph;
    static ArrayList<int[]> houses = new ArrayList<>();
    static ArrayList<int[]> chickenHouses = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<int[]> selected = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        LIMIT = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if(graph[i][j] == 2) {
                    chickenHouses.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chickenHouses.size()];

        findLeastDistance(0, 0);
        System.out.println(result);
    }

    private static void findLeastDistance(int depth, int start) {
        if(depth == LIMIT) {
            int sum = 0;
            for(int[] house : houses) {
                int min = Integer.MAX_VALUE;
                for(int[] select : selected) {
                    int distance = Math.abs(select[0] - house[0]) + Math.abs(select[1] - house[1]);
                    min = Math.min(min, distance);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        /**
         * 치킨집 조합
         */
        for(int i=start; i<chickenHouses.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected.add(chickenHouses.get(i));
                findLeastDistance(depth + 1, i + 1);
                // ArrayList의 끝부분 삭제라 O(1) 시간복잡도
                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }
    }
}
