import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int a : ability) {
            queue.add(a);
        }
        
        // 신입사원 교육 횟수
        for(int i = 0; i < number; i++) {
            int first = queue.poll();
            int second = queue.poll();
            
            queue.add(first + second);
            queue.add(first + second);
        }
        
        int answer = 0;
        
        while(!queue.isEmpty()) {

            answer += queue.poll();
        }
        
        return answer;
    }
}
