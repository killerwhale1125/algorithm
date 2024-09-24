package 백준.brute_force._1107_리모컨;

import java.io.*;
import java.util.*;

public class Retry3 {
    public static boolean[] broken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        broken = new boolean[10];
        if (M > 0) {  // 고장난 버튼이 있을 때만 처리
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;  // 고장난 버튼 표시
            }
        }

        int result = Math.abs(N - 100);

        for (int i=0; i<1000000; i++) {
            int count = isBroken(i);
            if (count > 0) result = Math.min(result, Math.abs(N - i) + count);
        }

        System.out.println(result);
    }

    private static int isBroken(int button) {
        if (button == 0) {
            if(broken[button]) return 0;
            else return 1;
        }
        int count = 0;
        while (button > 0) {
            if (broken[button % 10]) return 0;
            count++;
            button /= 10;
        }
        return count;
    }
}
