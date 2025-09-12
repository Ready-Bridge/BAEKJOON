import java.util.*;

class Solution {
    
    int [][] memo;
    
    private int maxTriangle(int x, int y, int[][] triangle) {
        
        if(memo[y][x] != -1) {
            return memo[y][x];
        }
        
        // 삼각형 바닥이면 종료
        if(y == (triangle.length - 1)) {
            return triangle[y][x];
        }
                
        int left = maxTriangle(x, y + 1, triangle);
        int right = maxTriangle(x + 1, y + 1, triangle);
        
        return memo[y][x] = triangle[y][x] + Math.max(left, right);
        
    }
    
    public int solution(int[][] triangle) {
        
        memo = new int[triangle.length][triangle.length];
        
        for(int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return maxTriangle(0, 0, triangle);
    }
}