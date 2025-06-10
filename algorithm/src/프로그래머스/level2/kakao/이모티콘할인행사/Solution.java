package 프로그래머스.level2.kakao.이모티콘할인행사;

import java.util.*;

class Solution {
    private final int[] ratios = {10, 20, 30, 40};
    private int[][] users;
    private final List<int[]> results = new ArrayList<>();

    private int[] buy(List<int[]> discounts) {
        int plus = 0;
        int total = 0;
        for (int i = 0; i < users.length; i++) {
            // 각 유저마다 plus 가입 대상인지 아닌지 판별
            int userRatio = users[i][0];    // 사용자 기준 비율
            int standard = users[i][1]; // 사용자 기준 가격
            int sum = 0;
            for (int[] d : discounts) {
                int ratio = d[0];
                int price = d[1];

                // 책정한 비율이 사용자 기준 비율보다 낮을 경우 continue
                if (ratio < userRatio) continue;

                sum += price;
            }

            if (sum >= standard) {
                plus++;
                continue;
            }
            total += sum;
        }
        return new int[]{plus, total};
    }

    private List<int[]> discount(List<Integer> discounts, int[] emoticons) {
        List<int[]> d = new ArrayList<>();
        int N = emoticons.length;
        for (int i = 0; i < N; i++) {
            int ratio = ratios[discounts.get(i)];
            d.add(new int[]{ratio, emoticons[i] - (emoticons[i] * ratio) / 100});
        }
        return d;
    }

    private void combine(int depth, List<Integer> discounts, int[] emoticons) {
        if (depth == emoticons.length) {
            List<int[]> d = discount(discounts, emoticons);
            results.add(buy(d));
            return;
        }

        for (int i = 0; i < 4; i++) {
            discounts.add(i);
            combine(depth + 1, discounts, emoticons);
            discounts.remove(discounts.size() - 1);
        }
    }

    public int[] solution(int[][] u, int[] emoticons) {
        users = u;
        combine(0, new ArrayList<>(), emoticons);
        return results.stream().sorted((r1, r2) -> {
                    if (r2[0] == r1[0]) return r2[1] - r1[1];
                    return r2[0] - r1[0];
                }).findFirst().get();
    }
}