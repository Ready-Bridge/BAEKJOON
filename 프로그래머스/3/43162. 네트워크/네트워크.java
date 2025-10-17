import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            
            if(!visited[i]) {
                q.add(i);
                visited[i] = true;   
                answer++;
            }
            
            while(!q.isEmpty()) {
            
                int computer = q.poll();
                
                for(int k = 0; k < n; k++) {
                    
                    if(!visited[k] && computers[computer][k] == 1) {
                        q.add(k);
                        visited[k] = true;
                    }
                }
            }
            
        }
        
        return answer;
    
    }
}