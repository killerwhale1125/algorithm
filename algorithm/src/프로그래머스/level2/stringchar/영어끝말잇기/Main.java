package 프로그래머스.level2.stringchar.영어끝말잇기;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int n = 2;
        int[] answer = new int[2];
        Map<String, Boolean> map = new HashMap<>();
        map.put(words[0], false);

        for(int i=1; i<words.length; i++) {
            String prev = words[i-1];
            String now = words[i];
            int nowOrder = i+1;// 현재 몇번재 게임중인지?
            map.put(now, map.containsKey(now));

            if(map.get(now) || prev.charAt(prev.length()-1) != now.charAt(0)) {
                int a = nowOrder % n;
                int b = nowOrder / n;
                // 몇번째 사람인지
                answer[0] = a == 0 ? n : a;
                // 몇번째 자신의 몇번째 차례에서 탈락한지
                answer[1] = a == 0 ? b : b + 1;
                break;
            }
        }

        System.out.println(answer[0] + " : " + answer[1]);
    }
}
