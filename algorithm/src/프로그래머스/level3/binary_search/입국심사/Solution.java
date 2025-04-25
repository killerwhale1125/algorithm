package 프로그래머스.level3.binary_search.입국심사;

class Solution {

    /* mid 시간에 모든 심사위원이 각각 몇명이나 처리하는지의 합계 */
    private boolean isPossible(int n, long time, int[] times) {
        long count = 0;
        for (int t : times) {
            count += time / t;
        }
        return count >= n;
    }

    public long solution(int n, int[] times) {
        long start = 1;
        long end = 1_000_000_000_000_000_000L;  // O ( 10억명 * 10억분 = 100경 )

        while (start < end) {
            long mid = (start + end) / 2;

            if (isPossible(n, mid, times)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        /* 종료 조건이 start == end 이기 때문에 start가 가장 최솟값 ( end 반환해도 상관없음 ) */
        return start;
    }
}