package 백준.greedy._1449_수리공항승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int tape = Integer.parseInt(st.nextToken());

        int[] broken = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            broken[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(broken);
        int curLocation = 0;
        int count = 0;
        for(int i=0; i<N; i++) {
            if(broken[i] <= curLocation) {
                continue;
            } else {
                count++;
                curLocation = broken[i] + tape - 1;
            }
        }
        System.out.println(count);
    }
}
