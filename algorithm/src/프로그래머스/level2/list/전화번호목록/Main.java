package 프로그래머스.level2.list.전화번호목록;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};
        boolean answer = true;
        Arrays.sort(phone_book);

        // 인접한 두 전화번호를 비교
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 앞의 전화번호가 뒤의 전화번호의 접두사인 경우 false를 반환
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
            }
        }
        System.out.println(answer);
    }
}
