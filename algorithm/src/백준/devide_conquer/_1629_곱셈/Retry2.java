package 백준.devide_conquer._1629_곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry2 {
    public static long A;
    public static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(devide(B));
    }

    private static long devide(long B) {

        if(B == 1) {
            return A % C;
        }

        long num = devide(B / 2);

        if(B % 2 != 0) {
            return ((num * num) % C * (A % C)) % C;
        }

        return num * num % C;
    }
}
