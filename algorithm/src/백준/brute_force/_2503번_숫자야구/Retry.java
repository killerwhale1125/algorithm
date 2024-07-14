package brute_force._2503번_숫자야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Retry {
    private static Map<String, Number> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map.put(st.nextToken(), new Number(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for(int i=123; i<=987; i++) {
            String n = String.valueOf(i);   // 324

            if(!isValid(n))
                continue;
            boolean isPossible = true;
            for(String x : map.keySet()) {
                Number number = map.get(x);
                int strike = 0;
                int ball = 0;

                for(int j=0; j<3; j++) {
                    char a = n.charAt(j);
                    char b = x.charAt(j);

                    if(a == b) {
                        strike++;
                    } else if(x.contains(String.valueOf(a))) {
                        ball++;
                    }
                }
                if(number.strike != strike || number.ball != ball) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                count++;
            }
        }

        System.out.println(count);
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
        int strike;
        int ball;

        public Number(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }
    }
}
