package 백준.brute_force._1476_날짜계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = {1, 1, 1};
        int[] result = new int[3];
        for(int i=0; i<arr.length; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        int E = result[0];
        int S = result[1];
        int M = result[2];
        int count = 1;

        while (true) {
            if(arr[0] == E && arr[1] == S && arr[2] == M) {
                System.out.println(count);
                break;
            }

            ++arr[0];   // 1 미리 증가
            ++arr[1];   // 1 미리 증가
            ++arr[2];   // 1 미리 증가

            if(arr[0] > 15) {
                arr[0] = 1;
            }

            if(arr[1] > 28) {
                arr[1] = 1;
            }

            if(arr[2] > 19) {
                arr[2] = 1;
            }

            count++;
        }
    }
}
