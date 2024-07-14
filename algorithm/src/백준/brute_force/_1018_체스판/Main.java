package brute_force._1018_체스판;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 처음 시도했던 방법
 * 8x8에서 조회할 때마다 2x2칸씩 아래위로 조회하여 각각 4x4번 조회하려고 시도
 * 첫째 값이 W와 B 둘다 조회하기 위하여 for문 2번 추가
 *
 * 개선
 * 1. 8x8로 변경
 * 2. for문 2번 돌지 않고 한번 반복문 실행 시 W와 B case 모두 count 기록
 * -> W와 B case 한번에 검사하지 않고 64 - count로 변경
 */

public class Main {
    public static char[][] board;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] blackAndWhite = {"B", "W"};

        board = new char[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N-7; i++) {
            for(int j=0; j<M-7; j++) {
                findMinCount(i, j);
            }
        }

        System.out.println(min);
    }

    private static void findMinCount(int x, int y) {

        int count = 0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                // 짝수일 때 
                if((i+j) % 2 == 0) {
                    if(board[x + i][y + j] != 'W') {
                        count++;
                    }
                }
                // 홀수일 때
                else {
                    if(board[x + i][y + j] != 'B') {
                        count++;
                    }
                }
            }
        }

        count = Math.min(count, 64 - count);


        min = Math.min(min, count);
    }
}
