package 프로그래머스.level2.math._124나라숫자;

/**
 * 각 자릿수 마다 판별
 */
public class Success {
    public static void main(String[] args) {
        int n = 21;
        String[] num = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            int remainder = n % 3;
            n /= 3;

            if (remainder == 0) {
                n--;
            }

            answer = num[remainder] + answer;
        }
        System.out.println(answer);
    }
}
