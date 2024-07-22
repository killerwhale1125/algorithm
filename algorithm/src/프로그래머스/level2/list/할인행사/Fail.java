package 프로그래머스.level2.list.할인행사;

import java.util.HashMap;
import java.util.Map;

public class Fail {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {1, 1, 1, 1, 1};
        String[] discount = {"banana", "apple", "rice", "pork", "pot"};

        Map<String, Integer> wantedMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantedMap.put(want[i], number[i]);
        }

        int dayCount = 0;

        for (int start = 0; start <= discount.length - 10; start++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int i = start; i < start + 10; i++) {
                discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
            }

            boolean isSatisfied = true;
            for (String item : wantedMap.keySet()) {
                if (discountMap.getOrDefault(item, 0) < wantedMap.get(item)) {
                    isSatisfied = false;
                    break;
                }
            }

            if (isSatisfied) {
                dayCount++;
            }
        }
        System.out.println(dayCount);
    }
}
