package brute_force._1107_리모컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {
    private static boolean[] broken = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }

        int min = Math.abs(N - 100);
        for(int i=0; i<1000000; i++) {

            // 누를 숫자에 부서진 버튼이 있는지 여부 확인
            int current = i;

            int pushCount = isPossible(current);

            if(pushCount > 0) {
                min = Math.min(min,
                        Math.abs(N - current) + pushCount);
            }

        }

        System.out.println(min);
    }

    private static int isPossible(int currentButton) {
        if(currentButton == 0) {
            if(broken[currentButton])
                return 0;
            else
                return 1;
        }
        int count = 0;
        while(currentButton > 0) {
            if(broken[currentButton % 10]) {
                return 0;
            }
            count++;
            currentButton /= 10;
        }

        return count;
    }
}
