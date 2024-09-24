package 백준.brute_force._1339_단어수학;

import java.io.*;
import java.util.Arrays;

/**
 * 핵심
 * 가중치를 구할 때 반복되는 알파벳의 자릿수에 따라 가중치를 추가한다.
 * ex ) GCB, ACDEB 일 경우 C는 GCB에서 10의 자리 ACDEB에서 1000의 자리니까 총 1010으로 계산
 */
public class Retry2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<str.length(); j++) {
                arr[str.charAt(j) - 'A'] += (int) Math.pow(10, str.length() - 1 - j);
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int turn = 25;
        int ans = 0;
        while(arr[turn] != 0) {
            ans += arr[turn] * num;
            turn--;
            num--;
        }

        System.out.print(ans);
    }
}
