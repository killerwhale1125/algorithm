package 백준.brute_force._1107_리모컨;

import java.util.*;

public class Main {
    static boolean[] broken = new boolean[10];

    static int possible(int c) {
        if(c == 0) {
            if(broken[0]) return 0;	// 0버튼이 고장났을경우 불가능 반환
            else return 1;	// 아닐경우 1 반환
        }

        int len = 0;
        while(c > 0) {
            if(broken[c % 10]) return 0;  // 현재 자리의 숫자 버튼이 고장났으면 0 반환
            len++;
            c /= 10;  // 다음 자리 숫자로 이동
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<m; i++) {
            int x = sc.nextInt();
            broken[x] = true;
        }

        //만약 숫자가 다고장나고 버튼만 눌러야할 상황
        int ans = n - 100;
        if(ans < 0) {
            ans = -ans;	// 버튼만 눌러야할 상황의 값
        }

        //모든 경우를 전부 판단
        for(int i=0; i<=600000; i++) {
            int push = i; // 누를 숫자

            //고장난 버튼만 빼고 눌렀을때의 경우의 갯수 ex push=누를 숫자
            int len = possible(push);
            if(len > 0) {  // 고장난 버튼 없이 입력 가능한 경우
                int press = Math.abs(push - n);  // c에서 n으로 이동하는 +, - 버튼 횟수
                ans = Math.min(ans, len + press);  // 최소 클릭 수 갱신 ( {누른 숫자 버튼 횟수} + {+나 - 누른 횟수} )
            }
        }
        System.out.println(ans);
    }
}
