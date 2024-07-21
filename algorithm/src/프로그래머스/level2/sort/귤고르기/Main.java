package 프로그래머스.level2.sort.귤고르기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 우선 정렬 후 Map으로 중복되는 값을 걸러낸 후
 * 그 key의 value값을 배열에 저장하여 배열 끝에서부터 K 인 원하는 수와 비교하며 값에 충족할 경우 정답
 */
public class Main {
    public static void main(String[] args) {
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int k = 4;
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : tangerine) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int[] arr = new int[map.size()];
        int i = 0;
        for(int key : map.keySet()) {
            int value = map.get(key);
            arr[i] = value;
            i++;
        }
        Arrays.sort(arr);

        int sum = 0;
        int count = 0;
        for(int j=arr.length-1; j>=0; j--) {
            if(sum >= k) {
                break;
            }
            sum += arr[j];
            count++;
        }

        System.out.println(count);
    }
}
