package brute_force._1107_리모컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Review {

    public static int N;
    public static int M;
    public static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }

        int result = Math.abs(N - 100);

        for(int i=0; i<1000000; i++) {
            // 누를 숫자에 부서진 버튼이 있는지 여부 확인
            int currentButton = i;
            int pushCount = possible(currentButton);

            // 숫자로 누를 수 있을 때
            if(pushCount > 0) {
                // 눌러야 할 수
                int press = Math.abs(N - currentButton);
                result = Math.min(result, press + pushCount);
            }
        }
        System.out.println(result);
    }

    // 몇회 누르는지 확인
    private static int possible(int pushButton) {
        if(pushButton == 0) {
            if(broken[pushButton]) return 0; // 부서져서 누를 수 없음
            else return 1;  // 안부서져서 1번 누를 수 있음
        }

        int count = 0;
        // 숫자 한자리씩 부서진지 검사
        while(pushButton > 0) {
            // 부서졌으면 전체를 못누르니 0 반환
            if(broken[pushButton % 10]) {
                return 0;
            }
            count++;
            pushButton /= 10;
        }
        return count;
    }
}
