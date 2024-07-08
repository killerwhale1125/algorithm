package binary_search._2110_공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int C;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /**
         * 20만 * log2N -> 20만 * 17 -> 대략 350만
         */
        Arrays.sort(arr);

        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt();
        int max = Integer.MIN_VALUE;
        /**
         * log2 10억 -> 29번
         * 29번 * 20만 = 580만
         * 
         * while문 580만 + sort 350만 = 대충 900만의 연산으로 풀이 가능
         * 즉 시간 제한 2초면 충분히 들어오고도 남는다
         */
        while(lt <= rt) {
            int mid = (lt + rt) / 2;

            int count = checkLength(mid);

            if(count >= C) {
                lt = mid + 1;
                max = Math.max(max, mid);
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(max);
    }

    private static int checkLength(int mid) {
        int count = 1;
        int first = arr[0];
        for(int i=1; i<N; i++) {
            if(arr[i] - first >= mid) {
                count++;
                first = arr[i];
            }
        }

        return count;
    }
}
