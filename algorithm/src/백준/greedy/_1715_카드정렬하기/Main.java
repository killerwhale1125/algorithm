package 백준.greedy._1715_카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 반례 : [10, 20, 30, 40, 50]
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            queue.add(sum);
            result += sum;
        }
        System.out.println(result);
    }
}
