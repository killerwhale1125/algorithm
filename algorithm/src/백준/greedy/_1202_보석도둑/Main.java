package 백준.greedy._1202_보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<int[]> jewelList;
    private static PriorityQueue<Integer> pricePriQueue;
    private static long sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        int[] bags = new int[K];
        jewelList = new ArrayList<>();
        pricePriQueue = new PriorityQueue<>(Collections.reverseOrder());

        // 가방
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            jewelList.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        // 보석 무게 기준 오름차순 정렬
        Collections.sort(jewelList, (M, V) -> M[0] - V[0]);

        for(int i=0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 가방 정보 배열 오름차순 정렬
        Arrays.sort(bags);

        /**
         * 가방을 정렬된 순서대로 순회하며
         * 해당 가방 무게 값보다 낮은 무게의 보석을 pricePriQueue에 저장하여 그곳에서 추가하는 방식
         */
        int jewelIndex = 0;
        for(int bagWeight : bags) {
            while (jewelIndex < jewelList.size() && jewelList.get(jewelIndex)[0] <= bagWeight) {
                pricePriQueue.add(jewelList.get(jewelIndex)[1]);
                jewelIndex++;
            }
            if(!pricePriQueue.isEmpty()) {
                sum += pricePriQueue.poll();
            }
        }

        System.out.println(sum);
    }
}
