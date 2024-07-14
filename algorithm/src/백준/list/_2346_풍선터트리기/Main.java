package 백준.list._2346_풍선터트리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Ballon> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            dq.add(new Ballon(i, Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        while(dq.size() != 1) {
            Ballon ballon = dq.pollFirst();
            int ballonNum = ballon.number;

            sb.append(ballon.index + " ");

            if(ballonNum < 0) {
                for(int i=0; i<Math.abs(ballonNum); i++) {
                    dq.addFirst(dq.pollLast());
                }
            } else {
                for(int i=0; i<ballonNum -1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            }
        }

        sb.append(dq.poll().index);
        System.out.println(sb);
    }

    static class Ballon {
        int index;
        int number;

        public Ballon(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
}
