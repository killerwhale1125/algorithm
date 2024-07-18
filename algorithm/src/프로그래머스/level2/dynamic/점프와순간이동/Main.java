package 프로그래머스.level2.dynamic.점프와순간이동;

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
