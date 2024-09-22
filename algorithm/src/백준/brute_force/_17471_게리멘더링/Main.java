package 백준.brute_force._17471_게리멘더링;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] adjList; // 인접 리스트
    static int[] people; // 각 구역의 인구 수
    static boolean[] selected; // 구역 선택 여부
    static int N; // 구역의 수
    static int min = Integer.MAX_VALUE; // 최소 인구 차이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        adjList = new ArrayList[N + 1];
        selected = new boolean[N + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인구 수 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 리스트 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int neighbors = Integer.parseInt(st.nextToken());
            for (int j = 0; j < neighbors; j++) {
                int neighbor = Integer.parseInt(st.nextToken());
                adjList[i].add(neighbor);
            }
        }

        // 구역 나누기 시도
        divide(1);

        // 결과 출력
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    // 구역 나누기
    private static void divide(int index) {
        if (index == N + 1) {
            // 두 선거구가 모두 비어있지 않은지 확인
            if (isValid()) {
                int sumA = 0, sumB = 0;
                for (int i = 1; i <= N; i++) {
                    if (selected[i]) {
                        sumA += people[i];
                    } else {
                        sumB += people[i];
                    }
                }
                min = Math.min(min, Math.abs(sumA - sumB));
            }
            return;
        }

        // 구역 A에 포함시키기
        selected[index] = true;
        divide(index + 1);

        // 구역 B에 포함시키기
        selected[index] = false;
        divide(index + 1);
    }

    // 선거구가 유효한지 확인
    private static boolean isValid() {
        boolean[] visited = new boolean[N + 1];
        int countA = 0, countB = 0;

        // 구역 A의 연결성 및 방문 확인
        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                dfs(i, true, visited);
                break;
            }
        }

        // 구역 B의 연결성 및 방문 확인
        for (int i = 1; i <= N; i++) {
            if (!selected[i]) {
                dfs(i, false, visited);
                break;
            }
        }

        // 두 구역이 각각 연결되어 있는지 확인
        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                countA++;
                if (!visited[i]) return false;
            } else {
                countB++;
                if (!visited[i]) return false;
            }
        }

        return countA > 0 && countB > 0;
    }

    // DFS를 사용한 연결성 확인
    private static void dfs(int node, boolean group, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor] && selected[neighbor] == group) {
                dfs(neighbor, group, visited);
            }
        }
    }
}