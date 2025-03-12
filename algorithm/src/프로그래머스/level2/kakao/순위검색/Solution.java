package 프로그래머스.level2.kakao.순위검색;

import java.util.*;

class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();

    // 문자열 조합 및 Map Score 저장
    private void combination(int depth, int score, String current, String[] info) {
        if (depth == 4) {
            String str = current.trim();
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(score);
            return;
        }

        combination(depth + 1, score, current + info[depth] + " ", info);
        combination(depth + 1, score, current + "- ", info);
    }

    // 이분탐색 O(log n)
    private int binarySearch(String key, int targetScore) {
        if (!map.containsKey(key)) return 0;
        List<Integer> scroes = map.get(key);
        int lt = 0, rt = scroes.size();

        while(lt < rt) {
            int mid = (lt + rt) / 2;
            if(scroes.get(mid) >= targetScore) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return scroes.size() - lt;
    }

    public int[] solution(String[] info, String[] query) {
        // DFS 활용 문자열 조합 후 Map 저장
        for (int i = 0; i < info.length; i++) {
            String[] strs = info[i].split(" ");
            combination(0, Integer.parseInt(strs[4]), "", strs);
        }

        // 이분 탐색을 위한 정렬
        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] queries = query[i].replaceAll(" and ", " ").split(" ");
            int score = Integer.parseInt(queries[4]);
            String key = queries[0] + " " + queries[1] + " " + queries[2] + " " + queries[3].trim();
            answer[i] = binarySearch(key, score);
        }

        return answer;
    }
}
