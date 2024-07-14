package 백준.greedy._1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Meeting> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Meeting(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int result = 0;
        int end = 0;
        for(Meeting meeting : list) {
            if(end <= meeting.start) {
                end = meeting.end;
                result++;
            }
        }
        System.out.println(result);
    }

    static class Meeting implements Comparable<Meeting> {

        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}