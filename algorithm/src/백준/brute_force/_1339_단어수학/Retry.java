package 백준.brute_force._1339_단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Retry {
    static int N;
    static int [] arr = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                arr[c - 'A'] += (int) Math.pow(10, str.length() - 1 - j);
            }
        }

        Arrays.sort(arr);

        int index = 25;
        int num = 9;
        int sum = 0;
        while(arr[index] != 0) {
            sum += arr[index] * num;
            num--;
            index--;
        }

        System.out.println(sum);
    }
}
