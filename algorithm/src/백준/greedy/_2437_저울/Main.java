package 백준.greedy._2437_저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 먼저 위에서 sum의 의미는 sum까지 무게를 측정할 수 있다는 의미라고 하였습니다.
 * 그렇다면 지금까지 가지고 있는 저울추로 1 ~ sum까지는 어떠한 방법으로도 만들 수 있다는 의미가 됩니다.
 * 이제 sum + 1인 값을 만들 수 없다면 그 값이 최솟값이 되는 겁니다.
 * 만약 sum = 5인 상태에서 다음 추가할 저울추가 6이라면 해당 저울추로 6도 만들 수 있고
 * 현재 저울추 무게 + sum 까지의 모든 무게를 만들 수 있습니다. (6 + 1, 6 + 2, ..., 6 + 5)
 * 하지만 다음 추가할 저울추가 7이라면??? 6을 만들 수 없기 때문에 6이 답이 됩니다.
 *
 * 포인트 -> 6(자신)을 만들 수 없기 때문에!!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weights);

        int sum = 0;
        for(int i=0; i<N; i++) {
            if(sum + 1 < weights[i]) {
                break;
            }
            sum += weights[i];
        }
        System.out.println(sum + 1);
    }
}
