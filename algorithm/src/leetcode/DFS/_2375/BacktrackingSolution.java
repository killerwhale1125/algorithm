package leetcode.DFS._2375;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingSolution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        // 사용된 숫자들을 추적할 배열
        boolean[] used = new boolean[n + 2];
        // 결과를 저장할 변수
        StringBuilder result = new StringBuilder();

        // 최소값을 저장하기 위한 변수
        String[] minResult = {""};

        // DFS를 시작하는 함수
        dfs(pattern, 0, used, new ArrayList<>(), minResult);

        return minResult[0];
    }

    private void dfs(String pattern, int idx, boolean[] used, List<Integer> current, String[] minResult) {
        // 모든 숫자를 다 사용했으면 패턴을 만족하는지 확인
        if (current.size() == pattern.length() + 1) {
            // 패턴이 맞는지 확인
            if (isValid(pattern, current)) {
                StringBuilder sb = new StringBuilder();
                for (int num : current) {
                    sb.append(num);
                }
                // 최소값을 찾으면 갱신
                if (minResult[0].equals("") || sb.toString().compareTo(minResult[0]) < 0) {
                    minResult[0] = sb.toString();
                }
            }
            return;
        }

        // 가능한 숫자들을 선택하고 DFS 호출
        for (int i = 1; i <= pattern.length() + 1; i++) {
            if (!used[i]) {  // 숫자가 이미 사용되었으면 건너뛰기
                used[i] = true;
                current.add(i);
                dfs(pattern, idx + 1, used, current, minResult);
                current.remove(current.size() - 1);  // 백트래킹
                used[i] = false;
            }
        }
    }

    // 패턴이 유효한지 확인하는 함수
    private boolean isValid(String pattern, List<Integer> current) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I' && current.get(i) > current.get(i + 1)) {
                return false;
            }
            if (pattern.charAt(i) == 'D' && current.get(i) < current.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
