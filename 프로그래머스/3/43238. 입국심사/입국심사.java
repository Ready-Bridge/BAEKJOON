class Solution {
    public long solution(int n, int[] times) {
        int start = 1;
        int end = 1000000000;
        
        while(end > start) {
            int t = (end + start) / 2;
            
            if(isValid(t, n, times)) {
                end = t;
            } else {
                start = end + 1;
            }
        }
        
        return start;
    }
    
    private boolean isValid(int t, int n, int[] times) {
        
        int cnt = 0;
        
        for(int time : times) {
            int temp = t / time;
            cnt += temp;
        }
        
        if(cnt >= n) {
            return true;
        } else {
            return false;
        }
    }
}