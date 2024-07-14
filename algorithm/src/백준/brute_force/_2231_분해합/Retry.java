package brute_force._2231_분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * break 안해서 틀림
 * Math.min 할 필요도 없이 그냥 찾자마자 바로 break;
 */
public class Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = 0;
        for(int i=1; i<N; i++) {
            int num = i;
            int sum = 0;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if(sum + i == N) {
                min = i;
                break;
            }
        }
        System.out.println(min);
    }
}
