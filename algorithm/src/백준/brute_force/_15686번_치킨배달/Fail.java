package 백준.brute_force._15686번_치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Fail {
    public static int N;
    public static int LIMIT;
    public static int[][] map;
    public static Map<String, ChickenHouse> chickenMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        LIMIT = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1) searchDistance(i, j);
            }
        }

        System.out.println(searchChickenHouseLimit());
    }

    private static int searchChickenHouseLimit() {
        Map<String, ChickenHouse> sortedMap = chickenMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e -> e.getValue().getVisit())) // visit 값을 기준으로 정렬
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // 동일 키에 대한 병합 처리
                        LinkedHashMap::new // 순서를 유지하는 LinkedHashMap에 수집
                ));

        int sum = 0;
        int limitCount = 0;
        for (String key : sortedMap.keySet()) {
            if(limitCount == LIMIT) break;
            ChickenHouse chickenHouse = chickenMap.get(key);
            sum += chickenHouse.getSum();
            limitCount++;
        }

        return sum;
    }

    private static void searchDistance(int x, int y) {
        int minX = 0;
        int minY = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 2) {
                    int sum = Math.abs((x + 1) - (i + 1)) + Math.abs((y + 1) - (j + 1));
                    if(sum < min) {
                        minX = i;
                        minY = j;
                        min = sum;
                    }
                }
            }
        }

        chickenMap.put(minX + "" + minY, chickenMap.getOrDefault(minX + "" + minY, new ChickenHouse(minX, minY)));
        ChickenHouse chickenHouse = chickenMap.get(minX + "" + minY);
        chickenHouse.increaseVisitCount();
        chickenHouse.addSum(min);
    }

    static class ChickenHouse {
        private int x;
        private int y;
        private int visit = 0;
        private int sum = 0;

        public ChickenHouse(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getVisit() {
            return this.visit;
        }

        public int getSum() {
            return this.sum;
        }

        public void addSum(int sum) {
            this.sum += sum;
        }

        public void increaseVisitCount() {
            this.visit += 1;
        }
    }
}
