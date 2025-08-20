class Solution {
    public int solution(int[] citations) {
        
        int result = 0;
        
        for(int i = 0; i < citations.length; i++) {
            int h = i + 1;
            int cnt = 0;
            for(int k = 0; k < citations.length; k++) {
                if(citations[k] >= h) {
                    cnt += 1;
                }
            }
            
            if(cnt >= h) {
                result = h;
            }
        }
        
        return result;
    }
}