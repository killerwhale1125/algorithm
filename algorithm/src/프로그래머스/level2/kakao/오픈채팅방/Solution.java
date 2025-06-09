package 프로그래머스.level2.kakao.오픈채팅방;

import java.util.*;

class Solution {

    private static String ENTER = "E";
    private static String LEAVE = "L";

    static class User {

        private String nickname;

        public void enter(String nickname) {
            this.nickname = nickname;
        }

        public void change(String nickname) {
            this.nickname = nickname;
        }

    }

    public String[] solution(String[] record) {
        Map<String, User> users = new HashMap<>();
        List<String> priority = new ArrayList<>();
        for (String r : record) {
            String[] info = r.split(" ");

            String action = info[0];
            String id = info[1];
            String nickname = null;
            if (info.length > 2) {
                nickname = info[2];
            }

            switch (action) {
                case "Enter" -> {
                    if (users.containsKey(id)) {
                        User user = users.get(id);
                        user.enter(nickname);
                    } else {
                        User user = new User();
                        user.enter(nickname);
                        users.put(id, user);
                    }
                    priority.add(id + " " + ENTER);
                }
                case "Leave" -> {
                    priority.add(id + " " + LEAVE);
                }
                case "Change" -> {
                    if (users.containsKey(id)) {
                        User user = users.get(id);
                        user.change(nickname);
                    }
                }
            }
        }

        return priority.stream()
                .map(str -> {
                    String[] info = str.split(" ");
                    User user = users.get(info[0]);

                    String action = switch (info[1]) {
                        case "E" -> "들어왔습니다.";
                        case "L" -> "나갔습니다.";
                        default -> "";
                    };

                    return user.nickname + "님이 " + action;
                })
                .toArray(String[]::new);
    }
}