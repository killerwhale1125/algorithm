package brute_force._2503번_숫자야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제
 * 1. 각 자릿수가 중복되면 안된다는 점을 고려하지 않음 -> isValid
 * 2. 각 자릿수 검사 시 조건 분석 미흡
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Map<String, Number> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            map.put(num, new Number(strike, ball));
        }

        int result = 0;
        for(int i=123; i<=987; i++) {
            String example = String.valueOf(i);

            if(!isValid(example))
                continue;

            int count = 0;
            boolean isPossible = true;
            for (String key : map.keySet()) {
                Number number = map.get(key);

                int strike = 0;
                int ball = 0;
                for(int j=0; j<3; j++) {
                    String a = example.substring(j, j+1);
                    String b = key.substring(j, j+1);

                    // 자릿수 값이 같을때
                    if(a.equals(b)) {
                        strike++;
                    }
                    // 같지는 않고 포함되어 있을 때
                    else if(key.contains(a)) {
                        ball++;
                    }
                }

                if(number.strike != strike || number.ball != ball) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isValid(String number) {
        if (number.charAt(0) == number.charAt(1) || number.charAt(0) == number.charAt(2) || number.charAt(1) == number.charAt(2)) {
            return false;
        }
        if (number.contains("0")) {
            return false;
        }
        return true;
    }

    static class Number {
        private int strike;
        private int ball;

        public Number(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }
    }
}
