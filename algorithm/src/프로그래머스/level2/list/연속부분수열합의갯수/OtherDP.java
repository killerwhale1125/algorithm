package 프로그래머스.level2.list.연속부분수열합의갯수;

import java.util.HashSet;
import java.util.Set;

/**
 * DP 풀이 방식
 * 핵심은 % length; 가 핵심이다.
 */
public class OtherDP {
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length];
        for(int i=1; i<=elements.length; i++){
            for(int j=0; j<elements.length; j++){
                dp[j] += elements[(i + j - 1) % elements.length];
                set.add(dp[j]);
            }
        }
        System.out.println(set.size());
    }
}
