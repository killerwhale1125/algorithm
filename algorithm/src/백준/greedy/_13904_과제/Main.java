package greedy._13904_과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 순차적 탐색
 * ArrayList -> 내부적으로 배열을 사용하기 때문에 인덱스를 사용하여 빠르게 요소에 접근 가능함
 * LinkedList -> 노드 기반이여서 각 노드가 이전 및 다음 노드에 대한 참조를 가진다.
 * 아래 문제로는 삽입은 초기에 한번 이뤄지고 삭제는 루프를 돌면서 한번씩만 삭제된다.
 * 순차적으로 List에 접근하기 때문에 시간복잡도는 O(N)으로 같다.
 * LinkedList를 사용했을 경우 배열기반인 ArrayList보다 오히려 성능이 저하될 수 있다.
 * 따라서 ArrayList가 더 효율적이다.
 *
 * [1 20]
 * [2 50] [2 50]
 * [3 30] [3 30] [3 30]
 *   1      2      3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Number> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            list.add(new Number(day, score));
            max = Math.max(max, day);
        }

        int sum = 0;
        for(int i=max; i>0; i--) {
            int day = i;

            Number number = new Number(0, 0);
            for(Number num : list) {
                if(num.day >= day) {
                    if(number.score < num.score) {
                        number = num;
                    }
                }
            }
            sum += number.score;
            list.remove(number);
        }

        System.out.println(sum);
    }

    static class Number {
        int day;
        int score;

        public Number(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }
}
