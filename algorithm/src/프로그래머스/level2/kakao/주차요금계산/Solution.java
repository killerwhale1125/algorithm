package 프로그래머스.level2.kakao.주차요금계산;

import java.util.*;

class Solution {

    static class CarRecord {
        private String time;

        public CarRecord(String time, String status) {
            this.time = time;
        }

        public int calculate(CarRecord cr) {
            int[] inTime = getHourAndMinute(this.time);
            int[] outTime = getHourAndMinute(cr.time);

            int inTotal = inTime[0] * 60 + inTime[1];
            int outTotal = outTime[0] * 60 + outTime[1];

            return outTotal - inTotal;
        }

        private int[] getHourAndMinute(String time) {
            String[] info = time.split(":");    // 시 / 분
            int hour = Integer.parseInt(info[0]);
            int minute = Integer.parseInt(info[1]);
            return new int[]{hour, minute};
        }
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, CarRecord> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for (String record : records) {
            String[] info = record.split(" ");
            String id = info[1];
            CarRecord cr = new CarRecord(info[0], info[2]);

            if (map.containsKey(id)) {
                CarRecord in = map.get(id);
                int total = in.calculate(cr);
                map.remove(id);
                result.put(id, result.getOrDefault(id, 0) + total);
            }
            else {
                map.put(id, cr);
            }
        }

        for (String id : map.keySet()) {
            CarRecord cr = map.get(id);
            int total = cr.calculate(new CarRecord("23:59", "OUT"));
            result.put(id, result.getOrDefault(id, 0) + total);
        }

        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        for (String id : result.keySet()) {
            int totalTime = result.get(id);
            int fee = basicFee;
            if (totalTime > basicTime) {
                fee += Math.ceil((double)(totalTime - basicTime) / unitTime) * unitFee;
            }
            result.put(id, fee);
        }

        List<String> ids = new ArrayList<>(result.keySet());
        Collections.sort(ids);

        int[] answer = new int[ids.size()];
        for (int i = 0; i < ids.size(); i++) {
            answer[i] = result.get(ids.get(i));
        }
        return answer;
    }
}