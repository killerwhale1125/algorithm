package 프로그래머스.level2.dfs.타겟넘버;

/**
 * 모든 숫자를 모두 사용해야한다
 */
public class Main {
    public static boolean[] visited;
    public static int answer = 0;
    public static int target;
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        target = 4;
        visited = new boolean[numbers.length];
        dfs(0, 0, numbers);
        System.out.println(answer);
    }

    static void dfs(int depth, int sum, int[] numbers) {
        if(depth == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        dfs(depth + 1, sum + numbers[depth], numbers);
        dfs(depth + 1, sum - numbers[depth], numbers);
    }
}
