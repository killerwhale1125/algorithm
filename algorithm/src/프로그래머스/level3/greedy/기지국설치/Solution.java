package 프로그래머스.level3.greedy.기지국설치;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
        solution(n, stations, w);
    }

    private static int solution(int n, int[] stations, int w) {
        int answer = 0;

        List<Integer> distances = new ArrayList<>();
        int start = 1;
        for(int station : stations) {
            int left = station - w;
            int distance = left - start;

            if(distance > 0) {
                distances.add(distance);
            }

            start = station + w + 1;
        }

        /**
         * start -> 15
         * n -> 15
         * start가 15라는 소리는 15부터 비어있다는 의미라서 <= 로 판단해야함
         */
        if(start <= n) {
            distances.add(n - start + 1);
        }

        int fixedW = w * 2  + 1;
        for(int distance : distances) {
            if(distance > fixedW) {
                answer += distance / fixedW;
                // 0일 경우는 그냥 무시
                if(distance % fixedW != 0) {
                    answer++;
                }
            } else {
                answer++;
            }
        }

        return answer;
    }
}
