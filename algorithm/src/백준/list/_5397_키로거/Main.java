package list._5397_키로거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Character> leftStack;
        Stack<Character>  rightStack;

        for(int i=0; i<N; i++) {
            leftStack = new Stack<>();
            rightStack = new Stack<>();
            String str = br.readLine();
            for(char x : str.toCharArray()) {

                switch(x) {
                    case '<':
                        if(!leftStack.isEmpty())
                            rightStack.push(leftStack.pop());
                        break;
                    case '>':
                        if(!rightStack.isEmpty())
                            leftStack.push(rightStack.pop());
                        break;
                    case '-':
                        if(!leftStack.isEmpty())
                            leftStack.pop();
                        break;
                    default:
                        leftStack.push(x);
                        break;
                }
            }
            StringBuilder sb = new StringBuilder();
            // 최종 비밀번호 생성
            while (!leftStack.isEmpty()) {
                sb.append(leftStack.pop());
            }
            // 왼쪽 스택은 역순이므로 반전
            sb.reverse();

            // 오른쪽 스택 문자 추가
            while (!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }

            System.out.println(sb);
        }

    }
}
