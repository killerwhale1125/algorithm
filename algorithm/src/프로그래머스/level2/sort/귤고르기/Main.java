package 프로그래머스.level2.sort.귤고르기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
