package 프로그래머스.level2.kakao.메뉴리뉴얼;

import java.util.*;
import java.util.stream.*;

class Solution1 {

    private String sort(String str) {
        return str.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private void combination(int depth, String order, String str, Map<String, Integer> map) {
        // 종료 조건
        if (depth == order.length()) return;

        for (char ch : order.toCharArray()) {
            String c = String.valueOf(ch);
            String sorted = sort(str + c);
            if (!str.contains(c) && !map.containsKey(sorted)) {
                map.put(sorted, map.getOrDefault(sorted, 0) + 1);
                combination(depth + 1, order, sorted, map);
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> mainMap = new HashMap<>();
        for(String order : orders) {
            Map<String, Integer> map = new HashMap<>();
            combination(0, order, "", map);

            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                mainMap.put(key, mainMap.getOrDefault(key, 0) + value);
            }
        }

        Map<Integer, List<Order>> resultMap = new HashMap<>();
        for(Map.Entry<String, Integer> entry : mainMap.entrySet()) {
            int value = entry.getValue();
            resultMap.computeIfAbsent(entry.getKey().length(), key -> new ArrayList<>());
            resultMap.get(entry.getKey().length()).add(new Order(entry.getKey(), entry.getValue()));
        }

        List<String> strs = new ArrayList<>();
        for (int num : course) {
            List<Order> orderList = resultMap.get(num);
            if (orderList == null) continue;

            // 가장 많이 주문된 조합 찾기 (2회 이상 주문된 것만)
            orderList.sort((o1, o2) -> Integer.compare(o2.value, o1.value));
            if (!orderList.isEmpty() && orderList.get(0).value >= 2) {
                int maxCount = orderList.get(0).value;
                for (Order o : orderList) {
                    if (o.value == maxCount) {
                        strs.add(o.name);
                    } else {
                        break;
                    }
                }
            }
        }

        Collections.sort(strs); // 사전 순 정렬
        return strs.toArray(new String[0]);
    }

    static class Order {
        private String name;
        private int value;

        public Order(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}
