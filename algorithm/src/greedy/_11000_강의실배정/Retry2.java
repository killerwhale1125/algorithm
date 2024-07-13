package greedy._11000_강의실배정;

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class Retry2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        Collections.sort(list, Retry2::compare);

        int endPoint = MIN_VALUE;
        int count = 0;
        for(int i=0; i<N; i++) {
            Meeting meeting = list.get(i);
            if(meeting.start >= endPoint) {
                endPoint = meeting.end;
                count++;
            }
        }
        System.out.println(count);
    }

    private static int compare(Meeting o1, Meeting o2) {
        if (o1.end == o2.end) {
            return o1.start - o2.start;
        }
        return o1.end - o2.end;
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
