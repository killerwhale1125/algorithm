package 프로그래머스.level2.kakao.뉴스클러스터링;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String str1 = "aa1+aa2".toUpperCase();
        String str2 = "AAAA12".toUpperCase();

        String modifiedStr1 = str1.replaceAll("[^a-zA-Z ]", "");
        String modifiedStr2 = str2.replaceAll("[^a-zA-Z ]", "");


    }
    private static String[] getBigrams(String str) {
        return IntStream.range(0, str.length() - 1)
                .mapToObj(i -> str.substring(i, i + 2)) // 두 글자씩 자르기
                .toArray(String[]::new); // 배열로 변환
    }

}
