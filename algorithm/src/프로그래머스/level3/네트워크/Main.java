package 프로그래머스.level3.네트워크;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean[] visited;
    public static List<ArrayList<Integer>> list;
    public static void main(String[] args) {

        int n = 3;

        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        int answer = 0;
        int size = computers.length;
        visited = new boolean[size+1];

        list = new ArrayList<>();

        for (int i = 0; i <= size; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<size; i++) {
            int[] arr = computers[i];
            for(int j=0; j<size; j++) {
                if(j == i) continue;
                if(arr[j] != 0) {
                    list.get(i + 1).add(j+1);
                }

            }
        }

        for(int i=1; i<=size; i++) {
            if(!visited[i]) {
                DFS(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void DFS(int number) {

        if(visited[number]) {
            return;
        }

        visited[number] = true;

        for(int x : list.get(number)) {
            DFS(x);
        }
    }
}
