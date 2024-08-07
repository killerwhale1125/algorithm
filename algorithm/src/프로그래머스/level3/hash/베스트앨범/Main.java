package 프로그래머스.level3.hash.베스트앨범;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] genres = {"pop", "pop", "pop"};
        int[] plays = {1, 1, 1};

        Map<String, List<Music>> map = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            map.computeIfAbsent(genres[i], key -> new ArrayList<>());
            List<Music> list = map.get(genres[i]);
            list.add(new Music(i, plays[i]));
        }

        List<Priority> list = new ArrayList<>();

        int arrLen = 0;
        for(String key : map.keySet()) {
            List<Music> music = map.get(key);
            music.sort((o1, o2) -> {
                if(o1.count == o2.count) return o1.index - o2.index;
                return o2.count - o1.count;
            });
            list.add(new Priority(key, music.stream().mapToInt(Music::getCount).sum()));
        }

        list.sort((o1, o2) -> { return o2.sum - o1.sum; });

        List<Integer> answerList = new ArrayList<>();
        for(Priority priority : list) {
            List<Music> musicList = map.get(priority.genre);
            int count = 0;
            for (Music music : musicList) {
                answerList.add(music.index);
                count++;
                if (count == 2) break;
            }
        }
        int[] answer = answerList.stream().mapToInt(i -> i).toArray();
    }

    static class Priority {
        String genre;
        int sum;

        public Priority(String genre, int sum) {
            this.genre = genre;
            this.sum = sum;
        }
    }

    static class Music {
        int index;
        int count;

        public Music(int index, int count) {
            this.index = index;
            this.count = count;
        }

        public int getCount() {
            return this.count;
        }
    }
}
