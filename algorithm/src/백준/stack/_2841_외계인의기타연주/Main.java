package 백준.stack._2841_외계인의기타연주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 각 줄에 대해 Stack을 사용하여 프렛을 관리
        Map<Integer, Stack<Integer>> map = new HashMap<>();

        int count = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int line = Integer.parseInt(st.nextToken());
            int plat = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(line, key -> new Stack<>());

            Stack<Integer> stack = map.get(line);

            // 현재 프렛을 스택에서 제거
            while (!stack.isEmpty() && stack.peek() > plat) {
                stack.pop();
                count++;
            }

            // 스택이 비어있지 않으며 현재 프렛이 이미 눌려져 있는 경우
            if (!stack.isEmpty() && stack.peek() == plat) {
                continue;
            }

            // 새로운 프렛을 스택에 추가
            stack.push(plat);
            count++;
        }

        System.out.println(count);
    }
}
