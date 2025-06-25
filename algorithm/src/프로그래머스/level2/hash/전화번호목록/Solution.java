package 프로그래머스.level2.hash.전화번호목록;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            String phone = phone_book[i];
            for (int j = phone.length(); j > 0; j--) {
                if (set.contains(phone.substring(0, j))) {
                    return false;
                }
            }
            set.add(phone);
        }
        return true;
    }
}