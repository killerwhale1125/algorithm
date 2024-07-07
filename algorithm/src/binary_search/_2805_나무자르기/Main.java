package binary_search._2805_나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] tree = new long[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        long lt = 0;
        long rt = Arrays.stream(tree).max().getAsLong();

        while(lt <= rt) {
            long mid = (lt+rt)/2;
            long sum=0;
            for(int i=0; i<N; i++) {
                if(tree[i] > mid)
                    sum += tree[i]-mid;
            }
            /**
             * 만약 값을 찾을 경우 lt는 무조건 rt보다 커짐
             * ex ) rt가 15인 정답이여서 sum과 M이 일치하다면
             *      조건처럼 lt는 15값을 가진 mid + 1이 되어 16이 되어버림
             *      따라서 while의 루프를 빠져나가게 되어 결국 rt가 정답
             */
            if(sum>=M) {
                /**
                 *  lt를 올려야만 sum 값이 줄어듬
                 *  rt를 내린다면 더욱 sum의 값이 작아진다는 의미
                 */
                lt = mid+1;
            } else if(sum<M) {
                rt = mid-1;
            }
        }
        System.out.println(rt);
    }
}
