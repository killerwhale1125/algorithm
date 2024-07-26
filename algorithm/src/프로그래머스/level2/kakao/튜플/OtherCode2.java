package 프로그래머스.level2.kakao.튜플;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OtherCode2 {
    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        Set<String> set = new HashSet<>();
        String s3 = s.replaceAll("[{]", " ");
        String s4 = s3.replaceAll("[}]", " ");
        String trim = s4.trim();
        // trim은 앞뒤 공백만 제거함. 내부 공백은 제거하지 않음
        String[] arr = trim.split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
    }
}
