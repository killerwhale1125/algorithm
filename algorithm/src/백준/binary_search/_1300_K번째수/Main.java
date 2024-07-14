package binary_search._1300_K번째수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * lower bound : 데이터내 특정 K값보다 같거나 큰값이 처음 나오는 위치를 리턴
 * upper bound : K값보다 처음으로 큰 값이 나오는 위치를 리턴
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 최대 10만
        int K = Integer.parseInt(br.readLine());    // 최대 10억
        long lt = 1;
        long rt = K;

        long result = 0;
        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            int count = 0;

            for(int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if(count >= K) {
                result = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(result);
    }
}
