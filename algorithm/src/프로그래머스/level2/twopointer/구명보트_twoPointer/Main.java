package 프로그래머스.level2.twopointer.구명보트_twoPointer;

import java.util.Arrays;

/**
 * 보트는 무조건 2명밖에 못탐
 * 그래서 정렬 후 첫번째 가벼운애랑 제일 무거운 마지막 놈이랑 더해서 limit이 안넘는게 가장 효율적인 식이다.
 */
public class Main {
    public static void main(String[] args) {
        int[] people = {40, 40, 40, 40};
        int limit = 240;
        Arrays.sort(people);
        int light = 0;
        int heavy = people.length - 1;
        int boats = 0;

        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                light++;
                heavy--;
            } else {
                heavy--;
            }
            boats++;
        }

        System.out.println(boats);
    }
}
