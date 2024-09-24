package 백준.brute_force._1182_부분수열합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry2 {
    private static int N;
    private static int S;
    private static int count;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        dfs(0, 0);
        System.out.println(S == 0 ? count - 1 : count);
    }

    private static void dfs(int index, int sum) {

        if(index == N) {
            if(sum == S) count++;
            return;
        }

        dfs(index + 1,sum + arr[index]);
        dfs(index + 1, sum);
    }
}
