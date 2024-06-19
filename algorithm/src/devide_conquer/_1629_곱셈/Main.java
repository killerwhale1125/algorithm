package devide_conquer._1629_곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        System.out.println(divide_conquer(A, B));
    }

    private static long divide_conquer(int a, int b) {

        if(b == 1) return a % C;

        long tmp = divide_conquer(a, b/2);

        if(b % 2 == 1) {
            /** 모듈러 연산 & 지수법칙 적용 **/
            return (((tmp * tmp % C) % C) * (a % C)) % C;
        }

        return tmp * tmp % C;
    }
}
