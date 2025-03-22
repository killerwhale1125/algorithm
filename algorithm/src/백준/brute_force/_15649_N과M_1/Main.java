package 백준.brute_force._15649_N과M_1;

import java.io.*;
import java.util.*;

public class Main {

    private static List<String> strs = new ArrayList<>();

    private static void dfs(int depth, String str, int N, int M, boolean[] visited) {
        if (depth == M) {
            strs.add(str.trim());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, str + " " + i, N, M, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dfs(0, "", N, M, new boolean[N + 1]);

        strs.stream().forEach(str -> System.out.println(str));
    }
}
