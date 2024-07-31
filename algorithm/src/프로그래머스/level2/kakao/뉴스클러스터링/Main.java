package 프로그래머스.level2.kakao.뉴스클러스터링;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        String str1 = "aa1+aa2".toUpperCase();
        String str2 = "AAAA12".toUpperCase();

        Map<String, Long> map1 = Arrays.stream(getBigrams(str1)).collect(groupingBy(o -> o, counting()));
        Map<String, Long> map2 = Arrays.stream(getBigrams(str2)).collect(groupingBy(o -> o, counting()));

        // 합집합의 크기
        int unionCount = 0;
        // 교집합의 크기
        int intersectionCount = 0;

        Set<String> allBigrams = new HashSet<>();
        allBigrams.addAll(map1.keySet());
        allBigrams.addAll(map2.keySet());

        for (String bigram : allBigrams) {
            long count1 = map1.getOrDefault(bigram, 0L);
            long count2 = map2.getOrDefault(bigram, 0L);
            unionCount += Math.max(count1, count2);
            intersectionCount += Math.min(count1, count2);
        }

        double jaccardSimilarity = (unionCount == 0) ? 1.0 : (double) intersectionCount / unionCount;
        int answer = (int) (jaccardSimilarity * 65536);
        System.out.println(answer);
    }

    /**
     * chars로 각 문자열을 IntStream으로 변환하고 isLetter를 통하여 각 문자가 알파벳인지 판단
     * allmatch -> 모두 맞을 경우 필터링
     */
    private static String[] getBigrams(String str) {
        return IntStream.range(0, str.length() - 1)
                .mapToObj(i -> str.substring(i, i + 2)) // 두 글자씩 자르기
                .filter(o -> o.chars().allMatch(Character::isLetter)) // 두 글자가 모두 알파벳인 경우만 필터링
                .toArray(String[]::new); // 배열로 변환
    }

}
