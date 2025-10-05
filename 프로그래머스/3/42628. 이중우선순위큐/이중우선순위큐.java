import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // 각 큐의 현재 개수를 추적하는 맵
        Map<Integer, Integer> counts = new HashMap<>();

        for (String operation : operations) {
            String[] arr = operation.split(" ");
            String command = arr[0];
            int value = 0;
            
            if (command.equals("I")) {
                value = Integer.parseInt(arr[1]);
            }

            if (command.equals("I")) {
                // 삽입
                minHeap.add(value);
                maxHeap.add(value);
                counts.put(value, counts.getOrDefault(value, 0) + 1);

            } else if (command.equals("D")) {
                
                // 삭제
                if (counts.size() == 0) {
                    
                    continue;
                }
                
                int targetValue;
                
                if (arr[1].equals("1")) { // 최댓값 삭제 
                    targetValue = maxHeap.poll();
                } else { // 최솟값 삭제 
                    targetValue = minHeap.poll();
                }
                
                // 맵에서 해당 값의 개수 감소
                counts.put(targetValue, counts.get(targetValue) - 1);
                
                // 개수가 0이 되면 맵에서 제거
                if (counts.get(targetValue) == 0) {
                    counts.remove(targetValue);
                }
                
                // 맵에 존재하지 않는 (이미 삭제된) 값들을 힙에서 제거
                clearInvalid(minHeap, counts);
                clearInvalid(maxHeap, counts);
            }
        }
        
        // 최종 결과 반환
        if (counts.size() == 0) {
            return new int[] {0, 0};
        } else {
            return new int[] {maxHeap.poll(), minHeap.poll()};
        }
    }
    
    // 힙의 peek() 값이 counts 맵에 없으면 계속 poll() 하여 제거
    private void clearInvalid(PriorityQueue<Integer> heap, Map<Integer, Integer> counts) {
        while (!heap.isEmpty() && !counts.containsKey(heap.peek())) {
            heap.poll();
        }
    }
}