package 프로그래머스.level3.kakao.보석쇼핑;

import java.util.*;

class Solution {

    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int totalSize = set.size();

        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[]{0, gems.length - 1};
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;

        while (end < gems.length) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            end++;

            while (map.size() == totalSize) {
                int gap = end - start;    // 구간
                if (gap < min) {
                    min = gap;
                    answer[0] = start + 1;
                    answer[1] = end;    // end++로 인해 end는 + 1 하지 않음
                }

                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }
        }

        return answer;
    }
}
