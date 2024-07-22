package 프로그래머스.level2.list._1차캐시;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Fail {
    public static final int CACHEHIT = 1;
    public static final int CACHEMISS = 5;
    public static void main(String[] args) {
        int n = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        PriorityQueue<City> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return o2.count - o1.count;
        });
        Set<String> cache = new HashSet<>();


        int time = 0;
        for(String city : cities) {
            // O(N)
            if(cache.contains(city)) {
                time += CACHEHIT;
                cache.remove(city);
                cache.add(city);
            }
            // O(1)
            else if(priorityQueue.size() < n) {
                priorityQueue.add(new City(city, 0));
                cache.add(city);
                time += CACHEMISS;
            }
            // LRU 교체 알고리즘 실행 O(1);
            else {
                City poll = priorityQueue.poll();
                cache.remove(poll.name);
                cache.add(city);
                priorityQueue.add(new City(city, 0));
                time += CACHEMISS;
            }
            // O(N)
            priorityQueue.stream().forEach(c -> {c.count++;});
        }
        System.out.println(time);
    }

    static class City {
        String name;
        int count;

        public City(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}
