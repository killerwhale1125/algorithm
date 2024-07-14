package 백준.brute_force._1748_수이어쓰기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Retry2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 9;
        int digit = 1;
        int count = 0;

        while(true) {
            if(N >= start + end -1) {
                count += end * digit;
                digit++;
                start *= 10;
                end *= 10;
            } else {
                count += (N - start + 1) * digit;
                break;
            }
        }
        System.out.println(count);

    }
}
