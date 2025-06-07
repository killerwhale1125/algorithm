package 프로그래머스.level2.hash.롤케이크자르기;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();

        for (int i = 0; i < topping.length; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }

        int result = 0;
        for (int i = 0; i < topping.length; i++) {
            int top = topping[i];
            left.add(top);

            right.put(top, right.get(top) - 1);
            if (right.get(top) == 0) {
                right.remove(top);
            }

            if (left.size() == right.size()) result++;
        }

        return result;
    }
}