package 프로그래머스.level2.greedy.광물캐기;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private final int[][] COST = {
            {1, 1, 1},   // 다이아 곡괭이
            {5, 1, 1},   // 철 곡괭이
            {25, 5, 1}   // 돌 곡괭이
    };

    // 곡괭이 종류별 피로도 계산
    private int calculateFatigueByPickType(int[] chunk, int pickType) {
        return chunk[0] * COST[pickType][0]
                + chunk[1] * COST[pickType][1]
                + chunk[2] * COST[pickType][2];
    }

    // 피로도 계산
    private int calculateFatigue(List<int[]> chunks, int[] picks) {
        int answer = 0;
        int cur = 0;
        for (int pickType = 0; pickType < 3; pickType++) {
            for (int k = 0; k < picks[pickType]; k++) {
                if (cur >= chunks.size()) break;

                answer += calculateFatigueByPickType(
                        chunks.get(cur++),
                        pickType
                );
            }
        }
        return answer;
    }

    // 다이아 -> 철 -> 돌 순으로 내림차순 정렬하여 반환
    private List<int[]> sortChunksDesc(List<int[]> chunks) {
        return chunks.stream()
                .sorted((a, b) -> {
                    if (b[0] != a[0]) return b[0] - a[0];   // 다이아
                    if (b[1] != a[1]) return b[1] - a[1];   // 철
                    return b[2] - a[2]; // 돌
                })
                .collect(Collectors.toList());
    }

    // 5개 그룹으로 광물을 쪼개어 List 반환
    private List<int[]> splitChunks(int maxChunks, String[] minerals) {
        List<int[]> list = new ArrayList<>();
        int[] cnt = new int[3];
        int used = 0;

        for (int i = 0; i < minerals.length && list.size() < maxChunks; i++) {
            switch (minerals[i]) {
                case "diamond" -> cnt[0]++;
                case "iron" -> cnt[1]++;
                case "stone" -> cnt[2]++;
            }
            used++;
            if (used == 5) {
                list.add(cnt);
                cnt = new int[3];
                used = 0;
            }
        }
        if (used > 0 && list.size() < maxChunks) list.add(cnt);
        return list;
    }
    
    // 캘 수 있는 덩어리 수 계산
    private int getMaxChunks(int[] picks, String[] minerals, int group) {
        int totalPicks = Arrays.stream(picks).sum();
        return Math.min((minerals.length + group - 1) / group, totalPicks);
    }

    public int solution(int[] picks, String[] minerals) {
        int group = 5;
        int maxChunks = getMaxChunks(picks, minerals, group);

        List<int[]> sortedChunks = sortChunksDesc(
                splitChunks(maxChunks, minerals)
        );

        return calculateFatigue(sortedChunks, picks);
    }
}
