import java.util.*;

class Solution {
    
    // 현재 왼손, 오른손의 키패드 위치
    int[] lPos = new int[] {0, 3};
    int[] rPos = new int[] {2, 3};
    
    // 상하좌우
    int[] dx = {0 ,0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    String click(String hand, int number, int numberX, int numberY) {
        
        boolean isRight = false;
        
        int gapRight = Math.abs((numberX - rPos[0])) + Math.abs((numberY - rPos[1]));
        int gapLeft = Math.abs((numberX - lPos[0])) + Math.abs((numberY - lPos[1]));
        
        // 떨어진 위치 동일하면 
        if(gapRight == gapLeft) {
            if(hand.equals("right")) {
                isRight = true;
            } 
        } else if(gapRight < gapLeft) { // 오른쪽 손이 더 가까이 있으면
            isRight = true;
        }
        
        // 오른쪽 손으로 눌러야하면
        if(isRight) {
            
            rPos[0] = numberX;
            rPos[1] = numberY;
            
            return "R";
        } else {
            
            lPos[0] = numberX;
            lPos[1] = numberY;
            
            return "L";
        }
    }
    
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int number : numbers) {
            
            int numberX;
            int numberY;
            
            if(number == 0) {
                numberX = 1;
                numberY = 3;
            } else {
                numberX = (number + 2) % 3;  
                numberY = (number - 1) / 3;
            }
            
            if(number == 1 || number == 4 || number == 7) {
                sb.append("L");
                lPos[0] = numberX;
                lPos[1] = numberY;
            } else if(number == 3 || number == 6 || number == 9) {
                sb.append("R");
                rPos[0] = numberX;
                rPos[1] = numberY;
            } else {
                sb.append(click(hand, number, numberX, numberY));
            }
        }
        
        return sb.toString();
        
    }
}