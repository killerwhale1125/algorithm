package 백준.stack._2841_외계인의기타연주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이전 코드의 문제점
 * Stack을 사용하려 의도한 것은 좋으나
 * if(stack.contains(x)) continue; 이 부분에서 contains를 사용하면
 * 시간 복잡도는 O(N) 이 발생한다.
 * 또한 삭제 작업에서도 문제가 발생한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int line = Integer.parseInt(st.nextToken());
            int plat = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(line, key -> new ArrayList<>());
            map.get(line).add(plat);
        }

        int count = 0;
        Stack<Integer> stack;

        for (int line : map.keySet()) {
            List<Integer> list = map.get(line);
            stack = new Stack<>();

            if(!list.isEmpty()) {
                for(int x : list) {
                    if(stack.isEmpty()) {
                        stack.push(x);
                        count++;
                        continue;
                    }

                    if(stack.contains(x)) continue;

                    if(stack.peek() < x) {
                        stack.push(x);
                    } else {
                        int size = stack.size();
                        for(int i=0; i<size; i++) {
                            if(x < stack.peek()) {
                                stack.pop();
                                count++;
                            }
                        }
                    }
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
