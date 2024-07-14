package 백준.greedy._2212_센서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if(K >= N) {
            System.out.println(0);
            return;
        }
        int[] sensor = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        IntStream.range(0, N)
                .forEach(o -> sensor[o] = Integer.parseInt(st.nextToken()));

        Arrays.sort(sensor);

        int[] diff = new int[N-1];
        IntStream.range(1, N)
                .forEach(o -> diff[o-1] = sensor[o] - sensor[o-1]);

        Arrays.sort(diff);

        int sum = Arrays.stream(diff).sum();
        for(int i=0; i<K-1; i++) {
            sum -= diff[diff.length-1-i];
        }
        System.out.println(sum);
    }
}
