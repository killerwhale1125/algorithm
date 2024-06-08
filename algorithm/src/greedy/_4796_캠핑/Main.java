package greedy._4796_캠핑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i = 1;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());   //1
            int P = Integer.parseInt(st.nextToken());   //2
            int V = Integer.parseInt(st.nextToken());   //3

            if(L == 0 && P == 0 && V == 0) break;

            int result = (V / P) * L;  // 10
            int max = V - (V / P) * P;  // 4

            if(max > L) {
                result += L;
            } else if(max <= L) {
                result += max;
            }

            System.out.println("Case " + i++ + ": " + result);
        }
    }
}
