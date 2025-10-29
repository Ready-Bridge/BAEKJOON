import java.util.*;

class Solution {
    public String solution(String input_string) {
        
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        
        // input_string에 있는 문자들의 종류
        for(char c : input_string.toCharArray()) {
            set.add(c);
        }

        int cnt = 0;
        boolean isSequence = false;
        
        for(char target : set) {
            
            cnt = 0;
            isSequence = false;
            
            for(char c : input_string.toCharArray()) {
                if(c == target) {
                    if(!isSequence) cnt ++;
                    isSequence = true;
                } else {
                    isSequence = false;
                }
            }
            
            if(cnt >= 2) {
                list.add(target);
            }
        }
        
        if(list.size() == 0) {
            return "N"; 
        } else {
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for(Character c : list) {
                sb.append(c);
            }
            return sb.toString();
        }
        
    }
}
