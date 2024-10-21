package 백준.greedy._1202_보석도둑;

import java.io.*;
import java.util.*;

public class Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        // 보석 정보 입력 (무게, 가격)
        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels[i][0] = weight;
            jewels[i][1] = price;
        }

        // 가방 정보 입력
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석을 무게 기준 오름차순 정렬
        Arrays.sort(jewels, Comparator.comparingInt(o -> o[0]));
        // 가방도 무게 기준 오름차순 정렬
        Arrays.sort(bags);

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        int jewelIndex = 0;
        for (int bagWeight : bags) {
            while(jewelIndex < N && bagWeight >= jewels[jewelIndex][0]) {
                q.add(jewels[jewelIndex][1]);
                jewelIndex++;
            }

            if (!q.isEmpty()) {
                sum += q.poll();
            }
        }

        System.out.println(sum);
    }
}
