package 백준.stack._2304_창고다각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 입력 값 Location에서 최솟값과 최댓값을 구한다. -> start, end
 * 큰값이 나오기 전까지 빈 인덱스를 계속 채워주면서 나중에 그 합을 전부 구하는 방식
 */
public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[L] = H;
            start = Math.min(L, start);
            end = Math.max(L, end);
        }

        Stack<Integer> height = new Stack<>();
        //왼쪽 비교
        int temp = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if(arr[i] < temp)  {
                height.push(i);
            }
            else {
                while (!height.isEmpty()) {
                    int x = height.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }
        height.clear();

        //오른쪽 비교
        temp=arr[end];
        for(int i = end - 1; i >= start; i--) {
            if(arr[i] < temp) height.push(i);
            else {
                while (!height.isEmpty()) {
                    int x = height.pop();
                    arr[x]=temp;
                }
                temp=arr[i];
            }
        }

        int result = 0;
        for (int i = start; i <= end; i++) {
            result += arr[i];
        }

        sb.append(result).append("\n");
        System.out.print(sb);
    }
}
