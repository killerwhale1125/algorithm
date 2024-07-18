package 프로그래머스.level2.bruteforce.카펫;

public class OtherCode {
    public static void main(String[] args) {
        int brown = 10;
        int yellow =2;
        int a = (brown+4)/2;
        int b = yellow+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
    }
}
