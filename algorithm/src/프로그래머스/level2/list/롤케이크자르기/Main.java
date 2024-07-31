package 프로그래머스.level2.list.롤케이크자르기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : topping) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(int x : topping) {
            set.add(x);
            map.put(x, map.get(x)-1);

            if(map.get(x) <= 0) {
                map.remove(x);
            }

            if(set.size() == map.size()) {
                answer++;
            }

        }
        System.out.println(answer);
    }
}
