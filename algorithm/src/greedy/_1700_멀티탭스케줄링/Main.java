package greedy._1700_멀티탭스케줄링;

import java.util.*;


/**
 * 기존 설계했던 방법
 * PriorityQueue를 사용하여 추가되면 자동으로 우선순위를 모아서 차례대로 빼서 추가하는 방식
 * 이 방식의 잘못된 점은 가장 먼 곳에 있는 조건을 고려하지 않음
 *
 * 
 */
public class Main {
    public static int minimumPlugUnplugs(int n, int k, int[] useOrder) {
        Set<Integer> multitap = new HashSet<>();
        int unplugs = 0;

        // [2, 3, 2, 3, 1, 2, 7]
        // 멀티탭 [2, 3]
        for (int i = 0; i < k; i++) {
            if (multitap.contains(useOrder[i])) {
                continue;
            }

            // 멀티탭에 자리가 있을 경우
            if (multitap.size() < n) {
                multitap.add(useOrder[i]);
            } 
            // 없을 경우
            else {
                int unPlug = -1;
                int far = -1;

                for (int device : multitap) {
                    int next = Integer.MAX_VALUE;
                    
                    // 현재 선택된 제품 다음부터 끝까지
                    for (int j = i + 1; j < k; j++) {
                        // 현재 탐색된 제품이 멀티탭과 동일하다면 탐색된 제품은 한번 더 사용된다.
                        if (useOrder[j] == device) {
                            next = j;   // j = 2    j = 3
                            break;
                        }
                    }

                    // 한번 더 사용될 제품이 멀리있는 제품보다 클 경우
                    if (next > far) {
                        // 멀리있는 제품이 나중에 사용되므로 해당 제품을 far에 저장
                        far = next;    // farthest = 2 -> farthest = 3
                        unPlug = device;
                    }
                }

                multitap.remove(unPlug);
                multitap.add(useOrder[i]);
                unplugs++;
            }
        }

        return unplugs;
    }

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
}
