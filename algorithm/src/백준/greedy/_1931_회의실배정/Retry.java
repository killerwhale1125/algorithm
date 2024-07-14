package 백준.greedy._1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        /** 정렬 **/
        Collections.sort(list);

        int endPoint = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0; i<N; i++) {
            Meeting meet = list.get(i);

            if(endPoint <= meet.start) {
                endPoint = meet.end;
                count++;
            }
        }

        System.out.println(count);
    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end)
                return this.start - o.start;
            return this.end - o.end;
        }
    }
}
