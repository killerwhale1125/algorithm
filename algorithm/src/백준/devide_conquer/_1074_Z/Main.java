package devide_conquer._1074_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간초과로 Fail
 * 전부 탐색하는 방식 X r, c 좌표 값을 사용하여 4등분으로 나누어 구간으로 이동해야함
 */
public class Main {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int pow = (int) Math.pow(2, N);
        divide(r, c, pow);
        System.out.println(count);
    }

    private static void divide(int r, int c, int size) {

        if(size == 1) {
            return;
        }

        if(r < size / 2 && c < size / 2) {
            divide(r, c, size / 2);
        }
        else if(r < size / 2 && c >= size / 2) {
            count += (size * size) / 4;
            divide(r, c- size, size / 2);
        }
        else if(r >= size / 2 && c < size / 2) {
            count += ((size * size) / 4) * 2;
            divide(r - size / 2, c, size / 2);
        }
        else if(r >= size / 2 && c >= size / 2) {
            count += ((size * size) / 4) * 3;
            divide(r- size, c- size, size / 2);
        }
    }
}
