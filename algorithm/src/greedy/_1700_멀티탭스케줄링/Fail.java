package greedy._1700_멀티탭스케줄링;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Fail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] useOrder = new int[k];

        // [2, 3, 2, 3, 1, 2, 7]
        for (int i = 0; i < k; i++) {
            useOrder[i] = scanner.nextInt();
        }

        int result = minimumPlugUnplugs(n, k, useOrder);
        System.out.println(result);
    }

    private static int minimumPlugUnplugs(int N, int K, int[] use) {
        Set<Integer> tab = new HashSet<>();
        int answer = 0;
        for(int i=0; i<K; i++) {
            if(tab.contains(use[i]))
                continue;

            if(tab.size() < N) {
                tab.add(use[i]);
            } else {
                int far = Integer.MIN_VALUE;
                // 나중에 덮어씌워져야함
                int unplug = -1;
                for(int device : tab) {
                    int next = Integer.MAX_VALUE;
                    for(int j=i+1; j<N; j++) {
                        if(device == use[j]) {
                            next = j;
                            break;
                        }
                    }

                    // 먼 녀석보다 더 먼 녀석이 있을 경우
                    // next를 MAX로 설정하여 1개만 찾았을 경우 나중에 MAX 값으로 덮어씌워져서 unplug 가 마지막 걸로 삭제가 된다.
                    if(far < next) {
                        far = next;

                        // 더 먼녀석은 삭제 되상이 되어야함.
                        unplug = device;
                    }
                }
                tab.remove(unplug);
                tab.add(use[i]);
                answer++;
            }
        }

        return answer;
    }
}
