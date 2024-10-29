package 프로그래머스.level3.hash.베스트앨범;

import java.util.*;
import java.util.stream.Collectors;

public class Retry {

    public static void main(String[] args) {

        String[] genres = {"pop", "pop", "pop"};
        int[] plays = {1, 1, 1};
        // 장르별로 곡을 저장할 맵
        Map<String, PriorityQueue<Music>> map = new HashMap<>();
        // 장르별 총 재생 수를 저장할 맵
        Map<String, Integer> genrePlayCount = new HashMap<>();

        // 장르와 곡 정보를 맵에 추가
        for (int i = 0; i < genres.length; i++) {
            Music music = new Music(i, plays[i]);

            // 장르별 재생 수 합산
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);

            // PriorityQueue를 통해 곡을 추가
            map.computeIfAbsent(genres[i], key -> new PriorityQueue<>((o1, o2) -> {
                if (o1.value == o2.value) return o1.index - o2.index; // 재생 수가 같을 경우 인덱스 기준으로 정렬
                return o2.value - o1.value; // 재생 수 기준으로 내림차순 정렬
            })).add(music);
        }

        // 장르를 재생 수 기준으로 정렬
        List<String> sortedGenres = genrePlayCount.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) // 내림차순 정렬
                .map(Map.Entry::getKey) // 장르만 추출
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();

        // 각 장르별로 상위 두 곡의 인덱스를 추출
        for (String genre : sortedGenres) {
            PriorityQueue<Music> q = map.get(genre);
            int count = 0;

            while (!q.isEmpty() && count < 2) {
                answer.add(q.poll().index); // 인덱스를 리스트에 추가
                count++;
            }
        }

        // 결과를 배열로 변환
        answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Music {
        final int index;
        final int value;

        public Music(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
