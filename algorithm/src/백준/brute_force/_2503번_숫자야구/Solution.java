package 백준.brute_force._2503번_숫자야구;

import java.util.*;
import java.io.*;

public class Solution {

    static class Question {
        int number;
        int strike;
        int ball;

        public Question(int number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    private static boolean isValidNumber(int num) {
        String s = String.valueOf(num);
        return s.charAt(0) != s.charAt(1) && s.charAt(1) != s.charAt(2) && s.charAt(0) != s.charAt(2) && !s.contains("0");
    }

    private static int[] getStrikeAndBall(String numStr, String questionStr) {
        int strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            if (numStr.charAt(i) == questionStr.charAt(i)) {
                strike++;
            } else if (questionStr.contains(String.valueOf(numStr.charAt(i)))) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    private static boolean isPossible(int num, List<Question> questions) {
        String numStr = String.valueOf(num);

        for (Question question : questions) {
            String questionStr = String.valueOf(question.number);
            int[] result = getStrikeAndBall(numStr, questionStr);

            if (result[0] != question.strike || result[1] != question.ball) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            questions.add(new Question(number, strike, ball));
        }

        int count = 0;
        for (int i = 123; i <= 987; i++) {
            if (isValidNumber(i) && isPossible(i, questions)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
