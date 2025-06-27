package 프로그래머스.level2.kakao.압축;

import java.util.*;

/**
 * 처음 내 답안 [ StringBuilder 풀이 ]
 */
class Solution2 {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        int dictIdx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), dictIdx++);
        }

        List<Integer> answer = new ArrayList<>();
        int i = 0;
        while (i < msg.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));
            int j = i + 1;

            while (j <= msg.length()) {
                String current = msg.substring(i, j);
                if (!map.containsKey(current)) {
                    map.put(current, dictIdx++);
                    break;
                }
                sb.setLength(0);
                sb.append(current);
                j++;
            }

            answer.add(map.get(sb.toString()));
            i += sb.length();
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * 가독성 리팩토링
 */
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        int dictIdx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), dictIdx++);
        }

        List<Integer> answer = new ArrayList<>();
        int i = 0;
        while (i < msg.length()) {
            int j = i + 1;
            String w = msg.substring(i, j);
            // substring 조건으로 <=
            while (j <=  msg.length() && map.containsKey(msg.substring(i, j))) {
                w = msg.substring(i, j);
                j++;
            }

            answer.add(map.get(w));

            if (msg.length() >= j) {
                map.put(msg.substring(i, j), dictIdx++);
            }

            i += w.length();
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
