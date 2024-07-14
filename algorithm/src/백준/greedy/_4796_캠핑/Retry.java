package 백준.greedy._4796_캠핑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx = 1;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");

            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0) break;

            System.out.print("Case " + idx++ + ": ");
            System.out.println((V % P) >= L ? (((V / P) * L) + L) : (((V / P) * L) + (V % P)));
        }
    }
}
