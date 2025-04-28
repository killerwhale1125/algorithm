package 프로그래머스.pccp.퍼즐_게임_챌린지;

class Solution {

    private int calculate(int index, int diff, long level, int[] times) {
        int result = 0;
        if (diff <= level) {
            result += times[index];
        } else {
            if (index > 0) {
                result += (times[index - 1] + times[index]) * (diff - level) + times[index];
            } else {
                result += times[index] * (diff - level) + times[index]; // 첫 번째 퍼즐의 경우
            }
        }
        return result;
    }

    /* 퍼즐 풀이 진행 */
    private long isSolve(long level, int[] diffs, int[] times) {
        long total = 0;

        for (int i = 0; i < diffs.length; i++) {
            total += calculate(i, diffs[i], level, times);
        }

        return total;
    }

    private long binarySearch(int[] diffs, int[] times, long limit) {
        long start = 1;
        long end = limit;

        while(start < end) {
            long level = (start + end) / 2;
            if (limit >= isSolve(level, diffs, times)) {
                end = level;
            } else {
                start = level + 1;
            }
        }

        return start;
    }

    public int solution(int[] diffs, int[] times, long limit) {
        return (int) binarySearch(diffs, times, limit);
    }
}