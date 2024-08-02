package 프로그래머스.level2.bruteforce.방문길이;

import java.util.HashSet;
import java.util.Set;

/**
 * 내가 했던 방식은 방문 위치(쩜.)를 체크해서 했던 방식임
 * 이 문제는 길을 추적해야함
 * ex ) 1.1 -> 1.2 로 Right로 간다면 1.1 1.2 이렇게 방문 위치를 체크하는 것이 아닌
 *      1.1에서 1.2로 갔다! 라는 것을 체크해야함
 *      따라서 Set을 사용해서 중복없이 경로를 추가함
 */

public class Fail {
    public static int[] U = {-1, 0};
    public static int[] D = {1, 0};
    public static int[] R = {0, 1};
    public static int[] L = {0, -1};
    public static boolean[][] visited;
    public static void main(String[] args) {
        int answer = 0;
        String dirs = "UD";
        Set<String> visitedPaths = new HashSet<>();
        int curX = 5;
        int curY = 5;
        for(char direction : dirs.toCharArray()) {
            int[] coordinate = new int[2];
            switch(direction) {
                case 'U':
                    coordinate = U;
                    break;
                case 'D':
                    coordinate = D;
                    break;
                case 'R':
                    coordinate = R;
                    break;
                case 'L':
                    coordinate = L;
                    break;
            }
            int nx = curX + coordinate[0];
            int ny = curY + coordinate[1];
            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            String path1 = curX + "" + curY + nx + "" + ny;
            String path2 = nx + "" + ny + "" + curX + "" + curY;

            if (!visitedPaths.contains(path1) && !visitedPaths.contains(path2)) {
                visitedPaths.add(path1);
                visitedPaths.add(path2);
                answer++;
            }

            curX = nx;
            curY = ny;

        }
        System.out.println(answer);
    }
}
