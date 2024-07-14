package greedy._1700_멀티탭스케줄링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 처음에 일반 배열로만 사용했기 때문에 unplug할 때 index를 찾을 수 없었음. (어떤 자리에 있는 것을 삭제해야할지?)
 * Set을 사용한다면 contains할 경우 시간도 줄일 수 있으며
 * Set은 중복을 허용하지 않기 때문에 값이 하나밖에 없어서
 * set.remove(3) 했을 때 3을 바로 삭제할 수 있음.
 * 배열이라면 3이 2개든 여러개든 들어가서 index를 통하여 삭제해줘야하는 단점을 극복해줌
 */
public class Retry2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] product = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<K; i++) {
            product[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * contains로 찾기 때문에 Set으로 조회 속도 향상
         * 조회 시 시간복잡도 O(1);
         */
        Set<Integer> tab = new HashSet<>();
        int count = 0;

        for(int i=0; i<K; i++) {
            if(tab.contains(product[i])) continue;

            /** 멀티탭에 꼽을 자리가 있다면 **/
            if(tab.size() < N) {
                tab.add(product[i]);
            }
            /** 멀티탭 자리가 꽉 찼다면 **/
            else {
                int far = -1; // -> 탐색하며 누가 더 거리가 먼지 여기다 저장
                int unplug = 0;
                /** 멀티탭에 있는 것을 하나씩 탐색 **/
                for(int device : tab) {
                    int next = Integer.MAX_VALUE;
                    /** 멀티탭에 꼽혀있는 것이랑 똑같은 것이 있다면 그 index를 저장 **/
                    for(int j=i+1; j<K; j++) {
                        if(device == product[j]) {
                            next = j;
                            break;
                        }
                    }

                    /**
                     * next가 far보다 거리가 멀다면 먼 거리를 next로 초기화
                     * unplug(멀티탭에서 뽑아야할 것)에 device 초기화
                     */
                    if(next > far) {
                        far = next;
                        unplug = device;
                    }
                }
                /**
                 * 만약 far, unplug, next를 0으로 초반에 초기화했다면 문제
                 * 1. [ 2, 3, 2, 3, 1, 2, 7 ]에서 멀티탭에 { 2, 3 }이 꼽혀있을 경우
                 *    2를 탐색할 경우 far == 5
                 *    그리고 3은 없어서 결국 far은 5 unplug는 2
                 *    하지만 사실은 3을 빼야하는데 2를 unplug 하면 안됨.
                 *    -- 3까지 있었다면 far은 3으로 3만 unplug 해줬으면 됐음
                 *    따라서 next를 MAX값으로 지정하여 2가 far로 지정돼어도
                 *    MAX로 인해 2 < MAX로 인하여 far == MAX로 초기화
                 *    또한 unplug도 같이 초기화된다.
                 */
                tab.remove(unplug);
                tab.add(product[i]);
                count++;
            }
        }

        System.out.println(count);
    }
}