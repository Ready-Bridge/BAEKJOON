import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        ArrayList<Integer> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>(); // 1이면 location
        
        for(int i = 0; i < priorities.length; i++) {
            list.add(priorities[i]);
            
            if(i == location) {
                q.add(new int[] {priorities[i], 1});
            } else {
                q.add(new int[] {priorities[i], 0});
            }
        }
        
        int order = 1;
        
        while(!q.isEmpty()) {
            
            int[] score = q.poll();
            
            if(score[0] < Collections.max(list)) {
                q.offer(score);
            } else {
                
                list.remove(Integer.valueOf(score[0]));
                
                if(score[1] == 1) {
                    return order;
                } else {
                    order++;
                }
            }
        }
        
        return -1;
    }
}