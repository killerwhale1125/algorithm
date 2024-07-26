package 프로그래머스.level2.kakao.튜플;

import java.util.*;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        List<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<100001; i++) {
            list.add(new ArrayList<>());
        }

        StringBuilder sb = new StringBuilder();
        for(char x : s.toCharArray()) {
            if(x == '{') {
                continue;
            }
            else if(x == ',') {
                if(!sb.isEmpty()) {
                    sb.append(",");
                }
            }
            else if(x == '}') {
                if(!sb.isEmpty()) {
                    String[] split = sb.toString().split(",");

                    for(String num : split) {
                        int number = Integer.parseInt(num);
                        ArrayList<Integer> intList = list.get(split.length);
                        intList.add(number);
                    }
                    sb = new StringBuilder();
                }
            }
            else {
                sb.append(x);
            }
        }

        list.stream().sorted(comparing(ArrayList::size));

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        for(int i=1; i<list.size(); i++) {
            ArrayList<Integer> arrayList = list.get(i);
            if(arrayList.size() <= 0) continue;

            for(int num : arrayList) {
                linkedHashSet.add(num);
            }
        }

        int[] answer = new int[linkedHashSet.size()];
        int i = 0;
        for(int x : linkedHashSet) {
            answer[i++] = x;
        }

        System.out.println(Arrays.toString(answer));
    }
}
