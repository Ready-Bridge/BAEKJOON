class Solution {
    public int solution(int[] menu, int[] order, int k) {
        
        int time = 0;
        int max = 0;
        int end = 0;
        
        for(int start = 0; start < order.length; start++) {
            
            if(time < start * k) {
                time = start * k;
            }
            
            time += menu[order[start]];
            
            while(end < order.length && end * k < time) {
                end++;
            }
            
            if(end - start > max) {
                max = end - start;
            }
            
        }
        
        return max;
    }
}
