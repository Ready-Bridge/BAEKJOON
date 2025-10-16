import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        // 1. 입차 차량 관리 Map (key: 차량번호, value: 입차시간(분))
        Map<String, Integer> parkingMap = new HashMap<>();
        // 2. 누적 주차 시간 관리 Map (key: 차량번호, value: 누적시간(분))
        Map<String, Integer> timeMap = new HashMap<>();

        for (String record : records) {
            String[] arr = record.split(" ");
            String[] timeArr = arr[0].split(":");
            int time = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            String carNumber = arr[1];
            String type = arr[2];

            if (type.equals("IN")) {
                parkingMap.put(carNumber, time);
            } else { // OUT
                // 입차 시간 가져오기
                int inTime = parkingMap.get(carNumber);
                // 주차 시간 = 출차 시간 - 입차 시간
                int parkingDuration = time - inTime;
                
                // 해당 차량의 누적 주차 시간에 합산
                timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0) + parkingDuration);
                
                // 출차했으므로 입차 목록에서 제거
                parkingMap.remove(carNumber);
            }
        }

        // 3. 출차 기록이 없는 차량 처리 (23:59 출차로 간주)
        int lastTime = 23 * 60 + 59;
        for (String carNumber : parkingMap.keySet()) {
            int inTime = parkingMap.get(carNumber);
            int parkingDuration = lastTime - inTime;
            timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0) + parkingDuration);
        }

        // 4. 누적 시간을 기준으로 최종 요금 계산
        // 차량 번호를 기준으로 정렬하기 위해 TreeMap 사용
        Map<String, Integer> feeMap = new TreeMap<>();
        for (String carNumber : timeMap.keySet()) {
            int totalTime = timeMap.get(carNumber);
            
            // 기본 요금
            int fee = basicFee;
            
            // 기본 시간 초과 시 추가 요금 계산
            if (totalTime > basicTime) {
                // 초과한 시간을 단위 시간으로 나누고 올림 처리
                int overTime = totalTime - basicTime;
                int count = (int) Math.ceil((double) overTime / unitTime);
                fee += count * unitFee;
            }
            feeMap.put(carNumber, fee);
        }

        // 5. 정렬된 결과를 배열로 변환하여 반환
        int[] answer = new int[feeMap.size()];
        int i = 0;
        for (int fee : feeMap.values()) {
            answer[i++] = fee;
        }

        return answer;
    }
}