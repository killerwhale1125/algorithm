package 백준.greedy._1744_수묶기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> minusList = new ArrayList<>();
        List<Integer> plusList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 0)
                plusList.add(num);
            else
                minusList.add(num);
        }
        Collections.sort(plusList, Collections.reverseOrder());
        Collections.sort(minusList);

        sum = 0;

        processList(plusList, (a, b) -> a < a * b);
        processList(minusList, (a, b) -> true);
        System.out.println(sum);
    }

    private static void processList(List<Integer> list, BiPredicate<Integer, Integer> condition) {
        int index = 0;
        while(index < list.size()) {
            int num = list.get(index);
            if(index + 1 < list.size() && condition.test(num, list.get(index + 1))) {
                sum += num * list.get(index + 1);
                index += 2;
            }
            else {
                // 남아있는 수가 더이상 2개가 아니거나 or 두 수를 곱했는데 원본보다 작을 경우
                sum += list.get(index);
                index++;
            }
        }
    }

    @FunctionalInterface
    interface BiPredicate<T, U> {
        boolean test(T t, U u);
    }
}
