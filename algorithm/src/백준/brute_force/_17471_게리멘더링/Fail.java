package 백준.brute_force._17471_게리멘더링;

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class Fail {
    static List<Integer>[] list;
    static List<Integer> A;
    static List<Integer> B;
    static int[] people;
    static boolean[] visited;
    static int min = MAX_VALUE;
    static int N;
    static final int END = 0;
    static final int FAIL = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = parseInt(br.readLine());
        list = new ArrayList[N + 1];
        people = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; i++) {
            people[i] = parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = parseInt(st.nextToken());
            for (int j=0; j<n; j++) {
                list[i].add(parseInt(st.nextToken()));
            }
        }

        for (int i=1; i<=N; i++) {

            /**
             * i -> 현재 index
             * j -> limit
             */
            for(int j=1; j<=N; j++) {
                A = new ArrayList<>();
                B = new ArrayList<>();
                visited = new boolean[N + 1];

                divideArea(i, j, A);
                divideArea(i, j, B);

                if(A.size() + B.size() != N) continue;
            }

        }
    }

    private static void divideArea(int index, int limit, List<Integer> ward) {
        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int value = dfs(index, 1, limit, ward);
                if (value == END) return;
                if (value == FAIL) return;
            }
        }
    }

    private static int dfs(int index, int depth, int limit, List<Integer> ward) {
        if (depth == limit) {
            return END;
        }

        for (int x : list[index]) {
            if (!visited[x]) {
                int value = dfs(x, depth + 1, limit, ward);
                if(value == END) return END;
                if(value == FAIL) return FAIL;
            }
        }

        return FAIL;
    }
}
