package greedy._1449_수리공항승;

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
        int L = Integer.parseInt(st.nextToken());

        int[] brokenPipe = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            brokenPipe[i] = Integer.parseInt(st.nextToken());
        }

        // 파이프 정렬
        Arrays.sort(brokenPipe);

        int checkLen = 0;
        int count = 0;
        for(int i=0; i<N; i++) {
            if(brokenPipe[i] > checkLen) {
                count++;
                checkLen = brokenPipe[i] + L - 1;
            }
        }
        System.out.println(count);
    }
}
