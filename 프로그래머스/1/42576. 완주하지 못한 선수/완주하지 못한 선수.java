import java.util.*;

class Solution {
    
    static public String answer = "hello";
    
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> hashmap = new HashMap<>();
        
        for(String person : participant) {
            hashmap.put(person, hashmap.getOrDefault(person, 0) + 1);
        }
        
        for(String person : completion) {
            hashmap.put(person, hashmap.get(person) - 1);
        }
        
        hashmap.forEach((key, value) -> {
            if(value == 1) {
                answer = key;
            }
        });
        
        return answer;
    }
}