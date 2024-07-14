package 백준.greedy._11047번_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int result = 0;
        for(int i=N-1; i>=0; i--) {
            if(K <= 0) {
                break;
            }
            if(arr[i] <= K) {
                result += K / arr[i];   // 4
                K %= arr[i];    // 200
            }
        }

        System.out.println(result);
    }
}
