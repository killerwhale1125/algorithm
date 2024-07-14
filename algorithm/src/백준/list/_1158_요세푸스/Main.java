package 백준.list._1158_요세푸스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        if(N == 1) {
            sb.append(q.poll() + ">");
        }
        while(!q.isEmpty()) {
            int count = 0;

            while(true) {
                count++;
                int poll = q.poll();
                if(count == K) {
                    sb.append(poll + ", ");
                    break;
                }
                q.offer(poll);
            }

            if(q.size() == 1) {
                sb.append(q.poll() + ">");
                break;
            }
        }

        System.out.println(sb.toString());

    }
}
