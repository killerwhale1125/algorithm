package devide_conquer._2104_부분배열고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Fail
 */
public class Main {
    static List<Long> v = new ArrayList<>();
    static long divq(int start, int end) {

        if(start == end)
            return v.get(start) * v.get(start);
        else {
            int mid = (start + end)/2;
            long res_left = divq(start, mid);
            // 좌측 분할 정복의 결과
            long res_right = divq(mid+1, end);
            // 우측 분할 정복의 결과
            long ret = Math.max(res_left, res_right);
            // 좌측과 우측 중 최댓값을 기록

            int left = mid;
            int right = mid+1;

            // 가장 최소를 구간으로 지정
            long minValue = Math.min(v.get(left), v.get(right));
            // 걸쳐진 인덱스의 크기는 2이므로, 두 인덱스 중 최솟값이 구간 최솟값

            long sum = v.get(left) + v.get(right);

            ret = Math.max(ret, minValue * sum);
            // 앞서 구한 최댓값과 현재 구한 사이 구간 값 중 최댓값을 기록

            // 둘 중에 하나라도 끝에 도달하지 않은 경우
            while(left > start || right < end) {
                // Left가 끝 단에 있거나 Left - 1 값 < Right + 1 값 일 때
                if(right < end && (left == start || v.get(left-1) < v.get(right+1))) {
                    right++;
                    minValue = Math.min(v.get(right), minValue);
                    sum += v.get(right);
                } else {
                    // Right가 끝 단에 있거나 Left - 1 값 >= Right + 1 값 일 때
                    left--;
                    minValue = Math.min(v.get(left), minValue);
                    sum +=  v.get(left);
                }

                // 앞서 구한 최댓값과 현재 구한 사이 구간 값 중 최댓값을 기록
                ret = Math.max(ret, minValue * sum);
            }
            return ret;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            v.add(Long.parseLong(st.nextToken()));
        }
        System.out.println(divq(0, n-1));
    }
}