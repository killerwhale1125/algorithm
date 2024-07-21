package 프로그래머스.level2.dynamic.점프와순간이동;

/**
 * 끝에서 -1한 값이 무조건 최소 거리이다.
 *
 * - - - - -
 * 1 2 3 4 5
 * 4까진 어떻게 알아서 간다 치고 4에서 5로 1칸 이동하는게 제일 효과적인 최솟값이다.
 * 2로 나눠짐 (짝수) ->
 * 2로 안나눠짐 (홀수) ->
 */
public class Main {
    public static void main(String[] args) {
        int N = 10;
        int K = 0;

        /**
         * 2로 나눠지면서 절반의 값이 되며
         * 안나눠지면 1을 마이너스
         */
        while(N != 0) {
            if(N % 2 == 0) N /= 2;
            else {
                N--;
                K++;
            }
        }
    }
}
