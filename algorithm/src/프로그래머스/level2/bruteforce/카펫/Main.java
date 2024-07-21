package 프로그래머스.level2.bruteforce.카펫;

/**
 * 노란색 기준으로 계산해서 겉에 bronw 갯수랑 일치하면 정답
 */
public class Main {
    public static void main(String[] args) {
        int[] answer = new int[2];
        int brown = 10;
        int yellow =2;
        int max = 0;
        int min = 0;
        for(int i=1; i<=yellow; i++) {
            int width = i;
            int height = yellow / i;
            if(width * height != yellow) continue;

            if(((width+2) * 2) + (height * 2) == brown) {
                max = Math.max(width + 2, height + 2);
                min = Math.min(width + 2, height + 2);
                break;
            }
        }
        answer[0] = max;
        answer[1] = min;
    }
}
