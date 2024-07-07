package binary_search._2512_예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long M = Integer.parseInt(br.readLine());

        long sum = Arrays.stream(arr).sum();  // 예산 요청 총합 계산
        long lt = 0;
        long rt = Arrays.stream(arr).max().getAsLong();  // 가장 큰 예산 요청

        if (sum <= M) {  // 모든 요청을 충족할 수 있는 경우
            System.out.println(rt);
            return;
        }

        while(lt <= rt) {
            long mid = (lt + rt) / 2;

            long tmp = 0;
            for (int i = 0; i < N; i++) {
                /**
                 * 문제를 잘못 이해함
                 * 상한액을 127로 지정해도 140이면 140을 tmp에 더해야하는 줄 알았음
                 * ( 문제 조건 : 그 이상인 예산요청에는 모두 상한액을 배정한다 )
                 */
                tmp += Math.min(arr[i], mid);
            }
            /** 
             * M 보다 낮거나 같을 경우 
             * 어차피 종료조건은 lt가 rt보다 낮을때까지인데
             * lt는 나중에 rt보다 높아질것이고
             * lt를 올렸다 가정하고 구하려는 값보다 커졌다 쳐도
             * 나중에 rt가 또 작아지기 때문에 <=로 하는게 맞음
             * **/
            if (tmp <= M) {
                lt = mid + 1;  // 상한선을 높여야 함
            } 
            /** M 보다 높을 경우 **/
            else {
                rt = mid - 1;  // 상한선을 낮춰야 함
            }
        }

        System.out.println(rt);
    }
}
