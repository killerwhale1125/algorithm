package 프로그래머스.level2.bruteforce.피로도;

public class Retry {
    public static boolean[] visited;
    public static int answer = 0;
    public static void main(String[] args) {
        int k = 78;
        int[][] dungeons = {{78, 18},{70, 11},{67, 9}, {60, 8}, {59, 2}, {57, 54}};
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
    }

    public static void dfs(int depth, int k, int[][] dungeons) {

        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }
}
