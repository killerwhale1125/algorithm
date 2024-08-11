package 프로그래머스.level3.heap.디스크컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * index -> 배열에서 어떤 작업을 현재 처리할지 
 * count -> 작업이 total에 추가될 때만 증가된다. (시간의 범위 안에 있는 작업들을 처리할 수 있을 경우)
 * total -> 총 시간 합계
 * end -> 마지막 시간
 *
 * 짧은 순으로 하는 이유
 * {{0, 3}, {1, 9}, {2, 6}, {7,1}} 이럴 경우 [1, 9] 와 [7, 1]
 * [1, 9]가 작업 시간이 더 긴데 긴걸 먼저해버리면 결국에 짧은것 또한 긴것에 영향을 받아서 길어진다.
 * 반면 [7, 1] 은 작업시간이 짧기 때문에 차라리 짧은거 먼저 해버리고 긴거 하면 [7, 1]얘는 긴거에 영향을 안받음
 */
public class OtherCode {
    public static void main(String[] args) {

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {20,1}};
        int answer = 0;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int index = 0;
        int count = 0;
        int total = 0;
        int end = 0;
        while(count < jobs.length) {

            // 현재 작업중인 job의 소요시간을 end로 잡고 end안에 요청이 들어오는 job들만 우선순위큐로 넣는다.
            // index < jobs.length -> index++로 배열에서 시간범위 안에 있는 애들을 찾는데 만약 배열 끝이라면 ++할 때 배열 범위 초과되기 때문에 조건 걸어야함
            while(index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }

            if(pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] cur = pq.poll();
                total += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
        }
        System.out.println(total / jobs.length);
    }
}
