package 프로그래머스.level2.stringchar.JadenCase문자열만들기;

public class Main {
    public static void main(String[] args) {
        // 문자열을 소문자로 변경
        String s = "  for the what 1what  ".toLowerCase();
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;
        String answer = "";
        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }
        System.out.println(answer);
    }
}
