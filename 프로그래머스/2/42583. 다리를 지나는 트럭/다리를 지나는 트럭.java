import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>(); // 다리 위 상태
        int time = 0;
        int currentWeight = 0;

        // 처음에 다리 길이만큼 0 채워두기
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int idx = 0; // 트럭 인덱스
        while (idx < truck_weights.length) {
            time++; // 시간 1초 경과
            currentWeight -= bridge.poll(); // 맨 앞 트럭(or 빈공간) 빠짐

            if (currentWeight + truck_weights[idx] <= weight) {
                // 새 트럭 올릴 수 있음
                bridge.add(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                
                bridge.add(0);
            }
        }

        
        time += bridge_length;

        return time;
    }
}
