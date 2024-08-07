package 프로그래머스.level3.bfs.단어변환;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * removeCharacterAtIndex(str, i); 이부분 아래 반례로 실패했었음
 */
public class Main {
    public static void main(String[] args) {
        String[] words = {"abb", "aba"};
        String begin = "aab";
        String end = "aba";
        int answer = 0;
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin));

        while(!q.isEmpty()) {
            Word poll = q.poll();
            for(int i=0; i<poll.word.length(); i++) {
                for(String str : words) {
                    char c = poll.word.charAt(i);
                    char c1 = str.charAt(i);
                    if(c != c1) {
                        String s = removeCharacterAtIndex(poll.word, i);
                        String s1 = removeCharacterAtIndex(str, i);
                        if(s.equals(s1) && !poll.set.contains(str)) {
                            Word newWord = new Word(str);
                            q.add(newWord);
                            newWord.set = poll.set;
                            newWord.set.add(newWord.word);
                            newWord.count = poll.count + 1;
                            if(newWord.word.equals(end)) {
                                answer = newWord.count;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static String removeCharacterAtIndex(String str, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append(str, 0, index);  // 인덱스 전까지의 부분 문자열 추가
        sb.append(str, index + 1, str.length());  // 인덱스 다음부터 끝까지의 부분 문자열 추가

        return sb.toString();
    }

    static class Word {
        String word;
        int count;
        Set<String> set = new HashSet<>();

        public Word(String word) {
            this.word = word;
        }
    }
}
