package binary_search._1654_랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static long[] arr;
    public static int K;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken()); // 1이상 10,000이하
        N = Integer.parseInt(st.nextToken()); // 1이상 1,000,000이하

        arr = new long[K];

        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /**
         * lt를 1로 설정하여 mid가 0이 되는 것을 방지한다.
         */
        long lt = 1;
        long rt = Arrays.stream(arr).sum(); // 최대 랜선 길이
        long max = Integer.MIN_VALUE;

        while(lt <= rt) {

            /**
             * by zero 예외 발생
             * mid가 0이라면 arr에서 나누기가 불가능해서 예외 터짐
             *
             */
            long mid = (lt + rt) / 2;

            long count = checkLenCable(mid);

            /** count < N **/
            if(count >= N) {
                lt = mid + 1;
                max = Math.max(max, mid);
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(max);
    }

    private static long checkLenCable(long mid) {

        int count = 0;
        for(long x : arr) {
            count += x / mid;
        }

        return count;
    }
}
