package 백준.brute_force._15649_N과M_1;

import java.io.*;
import java.util.*;

public class Main2 {
    private static void dfs(int depth, int N, int M, boolean[] visited, StringBuilder sb) {
        if (depth == M) {
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int len = sb.length();  // 원래 길이 저장
                sb.append(i).append(" ");  // 숫자 추가
                dfs(depth + 1, N, M, visited, sb);
                sb.setLength(len);  // 원래 길이로 복원
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        dfs(0, N, M, visited, new StringBuilder());
    }
}
