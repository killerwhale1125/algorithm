package 프로그래머스.level2.stringchar.스킬트리;

public class Main {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int answer = 0;
        for (String cur : skill_trees) {
            cur = cur.replaceAll("[^"+skill+"]", "");	//정규식으로 제거
            answer += skill.indexOf(cur)==0 ? 1 : 0;
        }

        System.out.println(answer);
    }
}
