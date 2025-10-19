import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 여분 체육복 있는 학생들중 도난당한 학생들 관련 처리
        for(int i = 0; i < lost.length; i++) {
            for(int k = 0; k < reserve.length; k++) {
                
                // 도난 당했으면
                if(lost[i] == reserve[k]) {
                    lost[i] = -1;
                    reserve[k] = -1;
                    break;
                }
            }
        }
        
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        // List에 lost와 reserve를 갱신하고 오름차순 처리 
        for(int i = 0; i < lost.length; i++) {
            if(lost[i] != -1) {
                lostList.add(lost[i]);
            }
        }
        
                // List에 lost와 reserve를 갱신하고 오름차순 처리 
        for(int i = 0; i < reserve.length; i++) {
            if(reserve[i] != -1) {
                reserveList.add(reserve[i]);
            }
        }
        
        Collections.sort(lostList);
        Collections.sort(reserveList);
        
        // lost를 돌면서 reserve에 빌려줄 수 있는 사람이 있으면 바로 빌려주면서 List 갱신
        for(int i = 0; i < lostList.size(); i++) {
            
            int tempLost = lostList.get(i);
            
            for(int k = 0; k < reserveList.size(); k++) {
                
                int tempReserve = reserveList.get(k);
                
                // 빌려줄 수 있다면 List에서 해당 학생들을 삭제 (인덱스도 하나씩 내려줌)
                if(tempLost + 1 == tempReserve || tempLost - 1 == tempReserve) {
                    lostList.remove(i--);
                    reserveList.remove(k--);
                    break;
                }
            }
        }
        
        return n - lostList.size();
        
    }
}