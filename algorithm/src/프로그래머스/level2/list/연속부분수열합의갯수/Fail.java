package 프로그래머스.level2.list.연속부분수열합의갯수;

import java.util.*;

public class Fail {
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        Set<Integer> set = new HashSet<>();
        int size = elements.length;
        Arrays.sort(elements);
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<size; i++) {
            int result = elements[i] + elements[i-1];
            queue.add(result);
            set.add(result);
        }
        queue.add(elements[0] + elements[size - 1]);
        set.add(elements[0] + elements[size - 1]);
        /**
         * 마지막 값 Set 에 저장
         */
        set.add(Arrays.stream(elements).sum());

        for(int i=2; i<size-1; i++) {
            int index = i;
            int count = 1;
            while(count <= size) {
                if(index > size - 1) index = 0;

                int poll = queue.poll();
                int result = poll + elements[index++];
                queue.add(result);
                set.add(result);
                count++;
            }
        }
        System.out.println(set.size() + Arrays.stream(elements).distinct().count());
    }
}
