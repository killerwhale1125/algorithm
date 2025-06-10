package 프로그래머스.level2.greedy.마법의엘레베이터;

/**
 반례 : storey = 765
 1의 자리 5 → 내릴지 올릴지 판단

 그다음 자리(10의 자리)가 6
 → 이걸 보면 어차피 다음 자리도 올릴 게 낫다는 판단 가능
 */
class Solution {
    public int solution(int storey) {
        int count = 0;
        while (storey > 0) {
            int end = storey % 10;
            int next = (storey / 10) % 10;
            System.out.println("end : " + end);
            System.out.println("next : " + next);
            if (end > 5 || (end == 5 && next >= 5)) {
                int value = 10 - end;
                storey += value;
                count += value;
                System.out.println("a : " + storey);
            } else {
                storey -= end;
                count += end;
                System.out.println("b : " + storey);
            }

            storey /= 10;
            System.out.println("count : " + count);
            System.out.println("storey : " + storey);
            System.out.println();
        }

        return count;
    }
}
