package 프로그래머스.level3.dfs.여행경로;

import java.util.*;

public class Fail {

    public static Map<String, List<Travel>> map;
    public static List<String> answerList = new ArrayList<>();
    public static int size;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"}, {"AAA", "BBB"}, {"AAA", "BBB"}, {"DDD", "ICN"}, {"BBB", "AAA"}};
        size = tickets.length;
        map = new HashMap<>();
        for(int i=0; i<size; i++) {
            map.computeIfAbsent(tickets[i][0], key -> new ArrayList<>());
            List<Travel> list = map.get(tickets[i][0]);
            list.add(new Travel(tickets[i][1]));
        }

        for(String key : map.keySet()) {
            map.get(key).sort((t1, t2) -> { return t1.end.charAt(0) - t2.end.charAt(0); });
        }
        answerList.add("ICN");

        DFS("ICN", 0);

        String[] answer = answerList.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(answer));
    }

    public static void DFS(String start, int depth) {
        List<Travel> list = map.get(start);

        if(depth == size || list.isEmpty()) return;

        for(Travel travel : list) {
            if(!travel.visited) {
                travel.visited = true;
                answerList.add(travel.end);
                DFS(travel.end, depth + 1);
            }
        }
    }

    static class Travel {
        String end;
        boolean visited;

        public Travel(String end) {
            this.end = end;
        }
    }
}
