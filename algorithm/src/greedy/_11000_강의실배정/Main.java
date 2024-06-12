package greedy._11000_강의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();
        boolean[] check = new boolean[1000000001];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        Queue<Integer> q = new PriorityQueue<>();
        int endTime=0;
        for(Lecture m : list) {
            endTime = m.end;

            if(!q.isEmpty() && q.peek() <= m.start) {
                q.poll();
            }
            q.add(endTime);
        }
        System.out.println(q.size());
    }

    static class Lecture implements Comparable<Lecture> {
        private int start;
        private int end;

        @Override
        public int compareTo(Lecture o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
