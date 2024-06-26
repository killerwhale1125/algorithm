package devide_conquer._1074_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {
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

    private static void divide(int r, int c, int pow) {

        if(pow == 1) {
            return;
        }

        if(r < pow / 2 && c < pow / 2) {
            divide(r, c, pow / 2);
        }

        else if(r < pow / 2 && c >= pow / 2) {
            count += (pow * pow) / 4;
            divide(r, c - pow / 2, pow / 2);
        }

        else if(r >= pow / 2 && c < pow / 2) {
            count += ((pow * pow) / 4) * 2;
            divide(r - pow / 2, c, pow / 2);
        }

        else if(r >= pow / 2 && c >= pow / 2) {
            count += ((pow * pow) / 4) * 3;
            divide(r - pow / 2, c - pow / 2, pow / 2);
        }
    }
}
