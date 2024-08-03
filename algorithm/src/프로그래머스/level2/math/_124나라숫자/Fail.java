package 프로그래머스.level2.math._124나라숫자;

public class Fail {
    public static void main(String[] args) {
        int n = 1;
        String[] dp = new String[n + 1];

        dp[1] = "1";
        dp[2] = "2";
        dp[3] = "4";
        int index = 1;
        String current = dp[index];
        int count = 1;

        for(int i=4; i<=n; i++) {
            dp[i] = current + dp[count];
            count++;
            if(count > 3) {
                current = dp[++index];
                count = 1;
            }
        }

        System.out.println(dp[n]);
    }
}
