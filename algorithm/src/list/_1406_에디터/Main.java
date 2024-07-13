package list._1406_에디터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int M = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            leftStack.push(str.charAt(i));
        }

        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            char s = st.nextToken().charAt(0);
            char x;

            switch(s) {
                case 'L':
                    if(!leftStack.isEmpty())
                        rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if(!rightStack.isEmpty())
                        leftStack.push(rightStack.pop());
                    break;
                case 'B':
                    if(!leftStack.isEmpty())
                        leftStack.pop();
                    break;
                case 'P':
                    x = st.nextToken().charAt(0);
                    leftStack.push(x);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        leftStack.stream().forEach(o -> sb.append(o));
        for(int i=rightStack.size()-1; i>=0; i--) {
            sb.append(rightStack.get(i));
        }
        System.out.println(sb);
    }
}
