package greedy._1449_수리공항승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 0은 자연수가 아님
 * 따라서 N과 L은 무조건 1 이상
 * 고장난 부분 -0.5 에서 계속 테이프 길이를 더해서 그 구간안에 고장난 수가 포함된다면 연산하지 않고 넘어감
 * 0.5 로 하는 방법이 더 직관적이여서 좋다.
 */
public class Retry2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int water[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(water);
        double left = water[0] - 0.5;
        int cnt = 1;
        for(int i=0; i<N; i++) {
            if(left+L < water[i]) {
                cnt++;
                left = water[i] - 0.5;
            }
        }
        System.out.println(cnt);
    }
}
