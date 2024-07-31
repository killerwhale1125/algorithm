package 프로그래머스.level2.bfs.게임맵최단거리;

/**
 * DFS로 풀어서 실패
 * 효율성 검사 실패
 */
public class Fail {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int min = Integer.MAX_VALUE;
    public static boolean[][] visited;
    public static int xLen;
    public static int yLen;
    public static void main(String[] args) {
        int answer = 0;
        int[][] maps = new int[5][5];
        xLen = maps.length;
        yLen = maps[0].length;
        visited = new boolean[xLen][yLen];
        visited[0][0] = true;
        dfs(0, 0, 1, maps);
//        if(min == Integer.MAX_VALUE) return -1;
    }

    static void dfs(int x, int y, int sum, int[][] maps) {
        if(x == xLen-1 && y == yLen-1) {
            min = Math.min(min, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 가는 조건은 무조건 커야함
            if(nx >= 0 && ny >= 0 && nx < xLen && ny < yLen && maps[nx][ny] != 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + 1, maps);
                visited[nx][ny] = false;
            }
        }

    }
}
