import java.util.*;

class Solution {
    
    Map<Long, Long> map = new HashMap<>();
    
    long find(long room) {
        
        // 바로 room 배정
        if(!map.containsKey(room)) {
            map.put(room, room + 1); // 이 room 다음 손님에게는 그 다음 room을 안내하도록 설정
            return room;
        } else {
            
            long tempRoom = find(map.get(room));
            map.put(room, tempRoom + 1);  
            
            return tempRoom;
        }
    }
    
    public long[] solution(long k, long[] room_number) {
        
        long[] answer = new long[room_number.length];
        
        for(int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }
        
        return answer;
    }
}