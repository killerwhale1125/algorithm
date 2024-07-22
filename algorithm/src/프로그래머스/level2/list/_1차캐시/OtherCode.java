package 프로그래머스.level2.list._1차캐시;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 내가 생각한 방안은 Set이 탐색이 빨라서 Set쓰고 우선순위는 PriorityQueue로 유지하는 방식인데 
 * 잘못된 점은 LRU 방식이랑 PriorityQueue랑 안맞음
 * PriorityQueue는 가장 큰 값 또는 가장 작은 값의 우선순위를 기반으로 정렬되기 때문에 LRU 캐시의 요구사항에 맞지 않음
 * 
 * HashSet은 삽입 순서를 유지하지 않음
 * 따라서 LinkedHashSet을 사용
 */
public class OtherCode {
    public static final int CACHE_HIT = 1;
    public static final int CACHE_MISS = 5;
    public static void main(String[] args) {
        int cacheSize = 2;
        int time = 0;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        if (cacheSize == 0) {
            time = CACHE_MISS * cities.length;
            System.out.println(time);
            return;
        }

        // 캐시의 도시 이름을 소문자로 변환
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        //
        /**
         * LRU 캐시를 구현하기 위해 LinkedHashSet 사용
         * new LinkedHashSet<>(): 초기 용량이 작은 경우, 많은 요소를 추가할 때마다 내부 구조를 재조정하므로 메모리 재배치가 발생할 수 있다.
         * new LinkedHashSet<>(cacheSize): 초기 용량을 충분히 크게 설정함으로써, 많은 요소가 추가될 때 내부 구조의 재조정이 필요 없어 성능과 메모리 효율이 좋아집니다.
         */
        Set<String> cache = new LinkedHashSet<>(cacheSize);


        for (String city : cities) {
            if (cache.contains(city)) {
                // 캐시 히트
                time += CACHE_HIT;
                // 캐시에서 제거한 후 다시 추가하여 가장 최근으로 업데이트
                cache.remove(city);
                cache.add(city);
            } else {
                // 캐시 미스
                time += CACHE_MISS;
                if (cache.size() >= cacheSize) {
                    // 캐시가 가득 차면 가장 오래된 항목 제거
                    for(String x : cache) {
                        cache.remove(x);
                        break;
                    }
                }
                cache.add(city);
            }
        }
        System.out.println(time);
    }
}
