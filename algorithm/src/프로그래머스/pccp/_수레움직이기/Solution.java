package 프로그래머스.pccp._수레움직이기;

/**
 * 2중 재귀 탐색 + 백트래킹
 * 모든 경우의 수 =
 * 모든 red의 다음 이동 (i)에 대해 →
 * 가능한 blue의 다음 이동 (j)을 고려하는 방식
 * 즉, O(5 x 5)의 선택을 전부 탐색 (4방향 + 제자리까지 한다면 5 x 5)
 *
 * 패턴 떠올리는 힌트
 * - 상태가 2개 이상 존재하고 ( red, blue )
 * - 동시에 변화해야 하며 ( 동시 이동 )
 * - 모든 조합을 고려해야 할 때
 */
class Solution {

    static int n,m;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int start[][];
    static int maze[][];
    static boolean visited[][][];
    static int answer;
    static int BLUE = 1;
    static int RED = 0;

    public int solution(int[][] maze0) {

        maze = maze0;

        answer = Integer.MAX_VALUE;

        n = maze.length;
        m = maze[0].length;
        start = new int[2][2];
        visited = new boolean[2][n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maze[i][j] == 1){
                    start[0][0] = i;
                    start[0][1] = j;
                }

                if(maze[i][j] == 2){
                    start[1][0] = i;
                    start[1][1] = j;
                }
            }
        }

        visited[RED][start[0][0]][start[0][1]] = true;
        visited[BLUE][start[1][0]][start[1][1]] = true;
        dfs(start, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    static void dfs(int waggons[][], int turn){
        int rx = waggons[0][0];
        int ry = waggons[0][1];
        int bx = waggons[1][0];
        int by = waggons[1][1];

        if(turn + 1 >= answer){
            return;
        }

        for(int i = 0; i < 4; i++){
            int nrx = maze[rx][ry] == 3 ? rx : rx + dx[i];
            int nry = maze[rx][ry] == 3 ? ry : ry + dy[i];

            if(maze[rx][ry] != 3 && isNotInRange(nrx, nry, RED)){
                continue;
            }

            for(int j = 0; j < 4; j++) {
                int nbx = maze[bx][by] == 4 ? bx : bx + dx[j];
                int nby = maze[bx][by] == 4 ? by : by + dy[j];

                if(maze[bx][by] != 4 && isNotInRange(nbx, nby, BLUE)) continue;

                // 다음 이동하려는 위치가 같을 때
                if(nrx == nbx && nry == nby) continue;

                // 서로 겹쳐서 이동할 때
                if((nrx == bx && nry == by) && (rx == nbx && ry == nby)) continue;
                
                // 서로 구멍에 도착했을 때
                if(maze[nrx][nry] == 3 && maze[nbx][nby] == 4){
                    answer = Math.min(answer, turn + 1);
                    return;
                }

                visited[RED][nrx][nry] = true;
                visited[BLUE][nbx][nby] = true;

                dfs(new int[][]{{nrx, nry},{nbx, nby}}, turn + 1);
                
                // 백트래킹
                visited[RED][nrx][nry] = false;
                visited[BLUE][nbx][nby] = false;
            }
        }
    }

    static boolean isNotInRange(int x, int y, int idx){
        return x < 0 || x >= n || y < 0 || y >= m || maze[x][y] == 5 || visited[idx][x][y];
    }

}