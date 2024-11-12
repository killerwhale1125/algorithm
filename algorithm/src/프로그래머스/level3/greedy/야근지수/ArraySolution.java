package 프로그래머스.level3.greedy.야근지수;

import java.util.Arrays;

public class ArraySolution {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {4, 3, 3};
        System.out.println(solution(n, works));
    }

    private static long solution(int n, int[] works) {
        long answer = 0;

        // 작업 배열을 내림차순으로 정렬
        Arrays.sort(works);

        // n 만큼 작업량 감소
        while (n > 0) {
            // 가장 큰 작업이 0이라면 더 이상 줄일 필요가 없음
            if (works[works.length - 1] == 0) break;

            // 가장 큰 작업을 줄임
            works[works.length - 1]--;

            n--;

            // 큰 작업이 감소했으므로 다시 정렬하여 가장 큰 작업을 마지막으로 배치
            int i = works.length - 1;
            while (i > 0 && works[i] < works[i - 1]) {
                // 내림차순을 유지하기 위해 값 교환
                int temp = works[i];
                works[i] = works[i - 1];
                works[i - 1] = temp;
                i--;
            }
        }

        // 야근 지수를 계산
        for (int work : works) {
            answer += (long) work * work;
        }

        return answer;
    }
}
