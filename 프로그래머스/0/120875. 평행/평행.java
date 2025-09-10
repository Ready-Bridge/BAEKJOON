import java.util.*;

class Solution {
    
    private double inclination(int x1, int x2, int y1, int y2) {
        return (double) (x1 - x2) / (y1 - y2);
    }
    
    public int solution(int[][] dots) {
        double incl12 = inclination(dots[0][0],dots[1][0],dots[0][1],dots[1][1]);
        double incl34 = inclination(dots[2][0],dots[3][0],dots[2][1],dots[3][1]);
        
        if(incl12 == incl34) {
            return 1;
        }
        
        double incl13 = inclination(dots[0][0],dots[2][0],dots[0][1],dots[2][1]);
        double incl24 = inclination(dots[1][0],dots[3][0],dots[1][1],dots[3][1]);
        
        if(incl13 == incl24) {
            return 1;
        }
        
        double incl14 = inclination(dots[0][0],dots[3][0],dots[0][1],dots[3][1]);
        double incl23 = inclination(dots[1][0],dots[2][0],dots[1][1],dots[2][1]);
        
        if(incl14 == incl23) {
            return 1;
        }
        
        return 0;
        
    }
}