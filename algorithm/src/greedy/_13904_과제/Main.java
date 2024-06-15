package greedy._13904_과제;

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
        int N = Integer.parseInt(br.readLine());
        List<Number> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            list.add(new Number(day, score));
            max = Math.max(max, day);
        }

        int sum = 0;
        for(int i=max; i>0; i--) {
            int day = i;

            Number number = new Number(0, 0);
            for(Number num : list) {
                if(num.day >= day) {
                    if(number.score < num.score) {
                        number = num;
                    }
                }
            }
            sum += number.score;
            list.remove(number);
        }

        System.out.println(sum);
    }

    static class Number {
        int day;
        int score;

        public Number(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }
}
