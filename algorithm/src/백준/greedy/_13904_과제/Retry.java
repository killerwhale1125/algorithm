package 백준.greedy._13904_과제;

import java.io.*;
import java.util.*;

public class Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        StringTokenizer st;
        int maxDay = Integer.MIN_VALUE;
        // 1,000
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            List<Integer> list = map.computeIfAbsent(day, k -> new ArrayList<>());
            list.add(score);
            maxDay = Math.max(maxDay, day);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        // 1,000
        for(int i=maxDay; i>=1; i--) {
            List<Integer> list = map.get(i);
            if(list != null && !list.isEmpty()) {
                for(int x : list) {
                    // O(nlogn) -> O( 1000 * log1000 )
                    pq.add(x);
                }
            }

            if(!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.println(sum);
    }
}
