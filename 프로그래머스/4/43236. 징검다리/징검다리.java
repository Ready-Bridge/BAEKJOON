import java.util.*;

class Solution {
    
    private boolean isValid(int mid, int [] rock, int n) {
        int removed = 0;
        int last = 0;
        
        for(int r : rock) {
            if(r - last < mid) {
                removed += 1;
            } else {
                last = r;
            }
        }
        
        return removed <= n;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        
        // distance를 추가한 새로운 rock 배열
        int[] rock = Arrays.copyOf(rocks, rocks.length + 1);
        rock[rocks.length] = distance;
        
        Arrays.sort(rock); // 정렬
        
        int start = 1;
        int end = distance + 1;
        
        while(end - start > 1) {
            
            int mid = (start + end) / 2;    
            
            if(isValid(mid, rock, n)) {
                start = mid;
            } else {
                end = mid;
            }
            
        }
        
        return start;
    }
}