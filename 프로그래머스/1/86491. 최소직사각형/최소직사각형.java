//import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            for(int j = 0; j < sizes[i].length; j++) {
                if(sizes[i][j] > x) {
                    x = sizes[i][j]; // 가장 max 값 저장 (무조건 들어가야함)
                }
            }
            
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            if(min > y) {
                y = min;
            }
        }
        
        return x * y;
        
    }
}