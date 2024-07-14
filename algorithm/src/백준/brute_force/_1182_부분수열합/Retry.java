package 백준.brute_force._1182_부분수열합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {
    public static int N;
    public static int SUM;
    public static int COUNT;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        SUM = Integer.parseInt(st.nextToken());
        COUNT = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        System.out.println(SUM == 0 ? COUNT - 1 : COUNT);
    }

    private static void DFS(int index, int sum) {
        if(index == N) {
            if(sum == SUM) {
                COUNT++;
            }
            return;
        }

        DFS(index + 1, sum + arr[index]);
        DFS(index + 1, sum);

    }
}
