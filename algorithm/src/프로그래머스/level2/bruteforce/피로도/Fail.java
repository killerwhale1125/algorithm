package 프로그래머스.level2.bruteforce.피로도;

import java.util.Arrays;

/**
 * 그리디로 착각한 문제
 * 그리디 X 완전탐색으로 풀어야함
 */
public class Fail {
    public static void main(String[] args) {
        int answer = 0;
        int k = 78;
        int[][] dungeons = {{78, 18},{70, 11},{67, 9}, {60, 8}, {59, 2}, {57, 54}};
        Subtraction[] sub = new Subtraction[dungeons.length];
        for(int i=0; i<dungeons.length; i++) {
            sub[i] = new Subtraction(i, dungeons[i][0] - dungeons[i][1]);
        }

        Arrays.sort(sub, (sub1, sub2) -> {
            return sub2.value - sub1.value;
        });

        for(Subtraction x : sub) {
            // 만약 현재 남아있는 피로도로 최소 소모 필요도를 만족시킨다면
            if(k >= dungeons[x.index][0]) {
                k -= dungeons[x.index][1];
                answer++;
            }
        }

        System.out.println(answer);
    }

    static class Subtraction {
        int index;
        int value;

        public Subtraction(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
