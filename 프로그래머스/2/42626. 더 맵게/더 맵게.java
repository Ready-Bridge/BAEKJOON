import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        for(int i = 0; i < scoville.length; i++) {
            q.offer(scoville[i]);
        }
        
        int cnt = 0;
        
        while(q.size() >= 2) {
            
            if(q.peek() >= K) {
                break;
            }
            
            int a = q.poll();
            int b = q.poll();
            
            q.offer(a + b * 2);
            cnt++;
        }
        
        if(q.peek() >= K) {
            return cnt;    
        } else {
            return -1;
        }
    }
}