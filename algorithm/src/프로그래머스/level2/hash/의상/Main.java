package 프로그래머스.level2.hash.의상;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[][] clothes = {};

        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);   // 조합 -> 안입는 경우도 고려하기 위해 + 1
        }

        answer -= 1; // 모두 '안입음'일 경우 -1 해주기

        System.out.println(answer);
    }
}
