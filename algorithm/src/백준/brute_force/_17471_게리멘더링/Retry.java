package 백준.brute_force._17471_게리멘더링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Retry {
    static List<Integer>[] adjList; // 인접 리스트
    static int[] people; // 각 구역의 인구 수
    static boolean[] selected; // 구역 선택 여부
    static int N; // 구역의 수
    static int min = Integer.MAX_VALUE; // 최소 인구 차이
    static final boolean A = true;
    static final boolean B = false;
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

        devide(1);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void devide(int index) {
        if (index == N + 1) {
            if(isValid()) {
                int sumA = 0, sumB = 0;
                for (int i = 1; i <= N; i++) {
                    if (selected[i] == A) {
                        sumA += people[i];
                    } else {
                        sumB += people[i];
                    }
                }
                min = Math.min(min, Math.abs(sumA - sumB));
            }
            return;
        }

        selected[index] = A;
        devide(index + 1);

        selected[index] = B;
        devide(index + 1);
    }

    private static boolean isValid() {
        boolean[] visited = new boolean[N + 1];

        for (int i=1; i<=N; i++) {
            if (selected[i] == A) {
                dfs(i, A, visited);
                break;
            }
        }

        for(int i=1; i<=N; i++) {
            if (selected[i] == B) {
                dfs(i, B, visited);
                break;
            }
        }

        int countA = 0, countB = 0;

        for(int i=1; i<=N; i++) {
            if (selected[i] == A) {
                countA++;
                if (visited[i] == B) return false;
            }

            if (selected[i] == B) {
                countB++;
                if (visited[i] == A) return false;
            }
        }

        return countA > 0 && countB > 0;
    }

    private static void dfs(int index, boolean type, boolean[] visited) {
        visited[index] = true;
        for (int x : adjList[index]) {
            if (!visited[x] && selected[x] == type) {
                dfs(x, type, visited);
            }
        }
    }

}
