import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // Max Heap: 중간값 이하의 '작은 절반'을 저장. (루트가 가장 큼)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min Heap: 중간값보다 큰 '큰 절반'을 저장. (루트가 가장 작음)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            // 1. 크기 맞추기: 번갈아가며 넣어서 양쪽 큐의 균형을 맞춤
            // 항상 maxHeap의 크기가 minHeap과 같거나 딱 1개 더 많도록 유지합니다.
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // 2. 대소 관계 교정
            // maxHeap의 최대값(루트)이 minHeap의 최소값(루트)보다 크면, 양쪽 값을 교환!
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int maxVal = maxHeap.poll();
                int minVal = minHeap.poll();
                
                maxHeap.offer(minVal);
                minHeap.offer(maxVal);
            }

            // 3. 중간값 기록
            // 위 규칙을 지키면 무조건 maxHeap의 루트가 우리가 찾는 중간값이 됩니다.
            sb.append(maxHeap.peek()).append("\n");
        }
        
        System.out.println(sb);
    }
}