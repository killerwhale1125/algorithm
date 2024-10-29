package 프로그래머스.level3.greedy.단속카메라;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        // 1. 차량의 경로를 나가는 시점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cameraCount = 0;
        int cameraPosition = Integer.MIN_VALUE; // 카메라 설치 위치

        // 2. 각 차량 경로에 대해 카메라 설치 판단
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            // 현재 카메라가 설치된 위치가 이 차량의 시작점보다 이전에 있으면 새 카메라 설치
            if (cameraPosition < start) {
                cameraCount++;
                cameraPosition = end; // 차량이 나가는 지점에 카메라 설치
            }
        }

        System.out.println(cameraCount);
    }
}
