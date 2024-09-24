package 백준.brute_force._1107_리모컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

/**
 * 1부터 100만까지 모든 수를 탐색하여 어떤 값이 가장 최솟값인지 탐색
 */
public class Retry2 {
    public static boolean broken[];
    public static int N;
    public static int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());

        int M = parseInt(br.readLine());
        broken = new boolean[10];
        if (M > 0) {  // 고장난 버튼이 있을 때만 처리
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;  // 고장난 버튼 표시
            }
        }

        /**
         * 모든 버튼이 고장났고 N이 30일 경우 70번 버튼을 직접 눌러야 함
         */
        int MIN = Math.abs(N - 100);

        for(int i=0; i<MAX; i++) {
            int count = checkBrokenButton(i);

            if(count > 0) {
                /**
                 * i번을 직접 눌렀을 때 몇번의 +나 -를 통하여 N 채널에 이동할 수 있는지?
                 * i가 N보다 커질경우 절댓값 변환
                 * Math.abs(N - i) -> + - 버튼 누르는 횟수
                 * count -> 번호를 직접 누른 횟수
                 */
                MIN = Math.min(MIN, Math.abs(N - i) + count);
            }

        }
    }

    private static int checkBrokenButton(int button) {
        if(button == 0) {
            if(broken[button]) return 0;
            else return 1;
        }

        int count = 0;
        while(button > 0) {

            if(broken[button % 10]) {
                return 0;
            }
            count++;
            button /= 10;
        }
        return count;
    }
}
