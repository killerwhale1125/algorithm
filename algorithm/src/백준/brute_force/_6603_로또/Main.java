package 백준.brute_force._6603_로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static int K;
    private static String[] nums;
    private static void combination(int depth, List<String> strs) {

        if (strs.size() == 6) {
            System.out.println(strs.stream().collect(Collectors.joining(" ")));
            return;
        }

        // 범위 초과
        if (depth > K - 1) return;

        strs.add(nums[depth]);
        combination(depth + 1, strs);

        strs.remove(strs.size() - 1);
        combination(depth + 1, strs);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            K = Integer.parseInt(st.nextToken());

            if (K == 0) break;

            nums = new String[K];
            for (int i = 0; i < K; i++) nums[i] = st.nextToken();

            combination(0, new ArrayList<>());
            System.out.println();
        }
    }
}
