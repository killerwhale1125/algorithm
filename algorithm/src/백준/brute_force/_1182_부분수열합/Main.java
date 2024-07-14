package brute_force._1182_부분수열합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 첫번째 시도 방법 & 문제점
 * 1. [-7 -> -3 -> ... N] 이렇게 단순하게?
 * 2.재귀 방식을 이해하지 못함. 0에서 -7 아닐 경우 [-3~N] 이 아니라 0에서 -7 아닐 경우 0
 *
 * 개선점
 * 1.index == 5일 때만 종료시켜 줄 때 sum을 계산하는 이유는 모든 수를 고려해야하기 때문이다.
 */
public class Main {
    public static int[] arr;
    public static int S;
    public static int N;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정수 갯수
        S = Integer.parseInt(st.nextToken());   // 정수
        count = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        /**
         * S == 0 ? 0 : count -> 0으로 설정 시 S가 0인데 값이 있어도 0으로 출력되서 불가능
         */
        System.out.println(S == 0 ? count - 1 : count);
    }

    private static void DFS(int index, int sum) {
        if(index == N) {
            if(sum == S){
                count++;
            }
            return;
        }

        DFS(index + 1, sum + arr[index]);
        DFS(index + 1, sum);
    }
}
