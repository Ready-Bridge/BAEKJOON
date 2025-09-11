import java.util.*;

class Solution {
    public int solution(String before, String after) {
        
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for(char c : before.toCharArray()) {
            if(map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        
        for(char c : after.toCharArray()) {
            if(map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }
        
        for(char c : map1.keySet()) {
            if(!map2.containsKey(c)) {
                return 0;
            }
            
            if(map2.get(c) != map1.get(c)) {
                return 0;
            }
        }
        
        return 1;
        
    }
}