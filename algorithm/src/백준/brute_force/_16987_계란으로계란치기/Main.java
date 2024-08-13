package 백준.brute_force._16987_계란으로계란치기;

import java.io.*;
import java.util.*;
import static java.lang.Integer.*;

public class Main {
    public static boolean[] broken;
    public static int N;
    public static List<Egg> eggs;
    public static int maxBrokenCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        eggs = new ArrayList<>();
        broken = new boolean[N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            eggs.add(new Egg(parseInt(st.nextToken()), parseInt(st.nextToken()), i));
        }

        crashEggDFS(0);
        System.out.println(maxBrokenCount);
    }

    public static void crashEggDFS(int index) {

        if (index == N) {
            int brokenCount = 0;
            for (boolean isBroken : broken) {
                if (isBroken) brokenCount++;
            }
            maxBrokenCount = Math.max(maxBrokenCount, brokenCount);
            return;
        }

        if (broken[index]) {
            // 현재 계란이 이미 깨져 있다면 다음 계란으로 넘어감
            crashEggDFS(index + 1);
            return;
        }

        boolean allBroken = true;
        for (int i = 0; i < N; i++) {
            if (i != index && !broken[i]) {
                allBroken = false;
                crash(eggs.get(index), eggs.get(i));
                crashEggDFS(index + 1);
                recovery(eggs.get(index), eggs.get(i));
            }
        }

        if (allBroken) crashEggDFS(index + 1);

    }

    private static void recovery(Egg currentEgg, Egg egg) {
        currentEgg.increaseDurability(egg.getWeight());
        egg.increaseDurability(currentEgg.getWeight());
        if (currentEgg.getDurability() > 0) broken[currentEgg.getIndex()] = false;
        if (egg.getDurability() > 0) broken[egg.getIndex()] = false;
    }

    public static void crash(Egg currentEgg, Egg egg) {
        if (currentEgg.decreaseDurability(egg.getWeight()) <= 0) broken[currentEgg.getIndex()] = true;
        if (egg.decreaseDurability(currentEgg.getWeight()) <= 0) broken[egg.getIndex()] = true;
    }

    static class Egg {
        // 내구도
        private int durability;
        // 무게
        private final int weight;
        // index
        private final int index;

        public Egg(int durability, int weight, int index) {
            this.durability = durability;
            this.weight = weight;
            this.index = index;
        }

        public int getDurability() {
            return this.durability;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getIndex() {
            return this.index;
        }

        public int decreaseDurability(int weight) {
            return this.durability -= weight;
        }

        public void increaseDurability(int weight) {
            this.durability += weight;
        }
    }
}
