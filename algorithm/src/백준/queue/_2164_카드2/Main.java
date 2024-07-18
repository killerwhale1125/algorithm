package 백준.queue._2164_카드2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            if(!queue.isEmpty()) {
                // 제거
                queue.poll();
                if(queue.size() != 1) {
                    queue.add(queue.poll());
                }
            }
        }

        System.out.println(queue.poll());
    }
}
