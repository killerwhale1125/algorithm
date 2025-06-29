package 프로그래머스.level3.hash.다단계칫솔판매;

/**
 칫솔 가격 -> 100원
 enroll -> 각 판매원 이름
 referral -> 추천인
 seller -> 판매 정보  (10만개)
 amount -> 판매량 정보
 10만(판매 정보) * log2(1만 - 추천인) -> 각각 업데이트
 */
import java.util.*;

class Solution {
    static class Seller {
        private String name;
        private int price;

        Seller(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public void addPrice(int price) {
            this.price += price;
        }

        public int getPrice() {
            return this.price;
        }

        public String getName() {
            return this.name;
        }
    }

    private void dfs(Seller current, int amount, Map<String, Seller> parent) {
        if (current == null) return;

        int commission = amount / 10;
        int profit = amount - commission;

        current.addPrice(profit);

        if (commission < 1) return;

        dfs(parent.get(current.name), commission, parent);
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Seller> sellers = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            String e = enroll[i];
            sellers.put(e, new Seller(e, 0));
        }
        sellers.put("-", new Seller("-", 0));

        Map<String, Seller> parent = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            String e = enroll[i];
            String r = referral[i];
            parent.put(e, sellers.get(r));
        }

        for (int i = 0; i < seller.length; i++) {
            Seller current = sellers.get(seller[i]);
            int total = amount[i] * 100;
            dfs(current, total, parent);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sellers.get(enroll[i]).getPrice();
        }

        return answer;
    }
}