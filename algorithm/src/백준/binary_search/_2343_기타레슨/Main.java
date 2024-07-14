package 백준.binary_search._2343_기타레슨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int max = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }

        Arrays.sort(arr);

        int lt = max;
        int rt = sum;
        int min = Integer.MAX_VALUE;

        while(lt <= rt) {

            int mid = (lt + rt) / 2;

            if(calculate(mid)) {
                min = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(min);
    }

    private static boolean calculate(int mid) {
        int sum = 0;
        int count = 1; // 첫 번째 블루레이

        for(int i=0; i<N; i++) {
            if(sum + arr[i] > mid) {
                count++;
                sum = 0;
            }
            sum += arr[i];
        }

        return count <= M;
    }
}
