package 백준.brute_force._1399_단어수학;

import java.io.*;
import java.util.*;

public class Fail {
    static Map<Character, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] alphabetNum = new int[100];
        map = new HashMap<>();
        String[] words = new String[N];
        for (int i=0; i<N; i++) {
            words[i] = br.readLine();
            for (char c : words[i].toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        /**
         * 길이가 긴것이 우선순위 높음.
         * 같을 경우 문자 내 같은것이 많은 것이 우선순위 높음
         */
        Arrays.sort(words, (o1, o2) -> {
            if (o2.length() == o1.length())
                return countAlphabetEq(o2) - countAlphabetEq(o1);
            return o2.length() - o1.length();
        });

        int current = 9;
        int sum = 0;
        StringBuilder sb;

        for(String word : words) {
            sb = new StringBuilder();
            for (char w : word.toCharArray()) {
                if (alphabetNum[w] != 0) {
                    sb.append(alphabetNum[w]);
                } else {
                    sb.append(current);
                    alphabetNum[w] = current--;
                }
            }
            sum += Integer.parseInt(sb.toString());
        }
        System.out.println(sum);
    }

    static int countAlphabetEq(String word) {
        int count = 0;
        for (char x : word.toCharArray())
            count += map.get(x);
        return count;
    }
}
