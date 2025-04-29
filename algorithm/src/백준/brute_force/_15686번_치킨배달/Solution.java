package 백준.brute_force._15686번_치킨배달;

import java.util.*;
import java.io.*;

public class Solution {
    private static int N, M;
    private static int min = Integer.MAX_VALUE;
    private static final List<int[]> chickens = new ArrayList<>();
    private static final List<int[]> users = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int  i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int token = Integer.parseInt(st.nextToken());
                if (token == 1) users.add(new int[]{i, j});
                if (token == 2) chickens.add(new int[]{i, j});
            }
        }

        dfs(0, 0, new ArrayList<>());
        System.out.println(min);
    }

    private static void dfs(int depth, int start, List<int[]> combines) {
        if (depth == M) {
            int total = 0;
            for (int[] user : users) {
                total += minDirection(user, combines);
            }
            min = Math.min(min, total);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            combines.add(chickens.get(i));
            dfs(depth + 1, i + 1, combines);
            combines.remove(combines.size() - 1);
        }
    }

    private static int minDirection(int[] user, List<int[]> combines) {
        int minDir = Integer.MAX_VALUE;
        int uX = user[0];
        int uY = user[1];
        for (int[] chicken : combines) {
            int cX = chicken[0];
            int cY = chicken[1];
            int dir = Math.abs(uX - cX) + Math.abs(uY - cY);
            minDir = Math.min(minDir, dir);
        }
        return minDir;
    }
}
