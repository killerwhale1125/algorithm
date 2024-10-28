package 프로그래머스.level3.greedy.단속카메라;

import java.util.Arrays;

public class Retry {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }

    private static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cameraPosition = Integer.MIN_VALUE;

        for(int[] route : routes) {
            int start = route[0];
            int end = route[1];

            if(cameraPosition < start) {
                answer++;
                cameraPosition = end;
            }
        }

        return answer;
    }
}
