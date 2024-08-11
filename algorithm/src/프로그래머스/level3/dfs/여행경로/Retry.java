package 프로그래머스.level3.dfs.여행경로;

import java.util.ArrayList;

public class Retry {
    private static ArrayList<String> list = new ArrayList<>();
    private static boolean[] visited;
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"}, {"AAA", "BBB"}, {"AAA", "BBB"}, {"DDD", "ICN"}, {"BBB", "AAA"}};
        visited = new boolean[tickets.length];

        DFS(0, "ICN", "ICN", tickets);
    }

    private static void DFS(int depth, String now, String path, String[][] tickets){


        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && now.equals(tickets[i][0])) {

            }
        }
    }

}
