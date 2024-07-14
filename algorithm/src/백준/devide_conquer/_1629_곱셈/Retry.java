package devide_conquer._1629_곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {
    public static int A;
    public static int B;
    public static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());   // 10
        B = Integer.parseInt(st.nextToken());   // 11
        C = Integer.parseInt(st.nextToken());   // 12

        System.out.println(divide(A, B));
    }

    private static long divide(int a, int b) {
        if(b == 1) {
            return a % C;
        }

        /** 분할하여 값 계산 **/
        long divideVal = divide(a, b / 2);

        /** 제곱근 값이 홀수일 경우 재귀 호출 안하도록 중복값 처리
         * moduler 연산 -> (x * y) % C = ((x % C)*(y % C)) % C
         * val * val * a % C는 long 범위 초과
         * x = val * val
         * y = a
         * ((val * val % C) * (a * C)) % C
         * **/
        if(b % 2 == 1) {
            return ((divideVal * divideVal % C) * (a % C)) % C;
        }

        /**
         * 홀수 아닐 경우 long값 넘지 않아서 모듈러 법칙 미적용
         * 2^31 * 2^31 은 long타입 초과되지 않아서 가능
         * long타입 최대 값 9경
         */
        return divideVal * divideVal % C;
    }
}
