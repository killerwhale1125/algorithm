package 백준.greedy._11000_강의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();
        for(int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(Lecture x : list) {
            if(!q.isEmpty()) {
                if(q.peek() <= x.start) {
                    q.poll();
                }
            }

            q.add(x.end);
        }

        System.out.println(q.size());
    }

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }
}
