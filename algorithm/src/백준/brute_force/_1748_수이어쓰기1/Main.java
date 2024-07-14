package 백준.brute_force._1748_수이어쓰기1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int count = 0;
        int start = 1;
        int end = 9;
        int digit = 1;

        while(true) {
            if(N >= start + end - 1) {
                count += end * digit;
                start *= 10;
                end *= 10;
                digit++;
            } else {
                count += (N-start + 1) * digit;
                break;
            }
        }
        System.out.println(count);
        bf.close();
    }
}
