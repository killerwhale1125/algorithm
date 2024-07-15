package 백준.stack._2304_창고다각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Fail {
    public static List<Rectangle> list;
    public static int sum;
    public static Rectangle[] maxArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int location = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new Rectangle(location, height));
        }

        list.sort((r1, r2) -> r1.location - r2.location);
        maxArr = new Rectangle[2];
        sum = 0;
        /**
         * <- -> 두번 탐색
         */
        leftDirection();
        rightDirection();

//        int length = Math.abs(maxArr[0].location - maxArr[1].location);

        int result = maxArr[0].height + sum;
        System.out.println(result);
    }

    private static void leftDirection() {
        Stack<Rectangle> stack = new Stack<>();
        for (Rectangle rectangle : list) {
            if (stack.isEmpty()) {
                stack.push(rectangle);
            } else {
                if (stack.peek().height < rectangle.height) {
                    Rectangle pop = stack.pop();
                    sum += (rectangle.location - pop.location) * pop.height;
                    stack.push(rectangle);
                }
            }
        }

        if(!stack.isEmpty()) {
            maxArr[0] = stack.pop();
        }
    }

    private static void rightDirection() {
        Stack<Rectangle> stack = new Stack<>();

        for(int i=list.size()-1; i>=0; i--) {
            Rectangle rectangle = list.get(i);
            if (stack.isEmpty()) {
                stack.push(rectangle);
            } else {
                if (stack.peek().height < rectangle.height) {
                    Rectangle pop = stack.pop();
                    sum += (pop.location - rectangle.location) * pop.height;
                    stack.push(rectangle);
                }
            }
        }
        if(!stack.isEmpty()) {
            maxArr[1] = stack.pop();
        }
    }


    static class Rectangle {
        int location;
        int height;

        public Rectangle(int location, int height) {
            this.location = location;
            this.height = height;
        }
    }
}
