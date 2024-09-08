package 백준.greedy._1946_신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());

            List<int[]> list = new ArrayList<>();
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int score1 = Integer.parseInt(st.nextToken());
                int score2 = Integer.parseInt(st.nextToken());
                list.add(new int[]{score1, score2});
            }

            list.sort((score1, score2) -> score1[0] - score2[0]);

            int min = Integer.MAX_VALUE;
            int count = 0;
            for(int n=0; n<N; n++) {
                int score2 = list.get(n)[1];
                if(score2 < min) {
                    count++;
                    min = Math.min(min, score2);
                }
            }
            System.out.println(count);
        }
    }
}
