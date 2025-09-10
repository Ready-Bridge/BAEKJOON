import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if(!set.contains(c)) {
                sb.append(c);
                set.add(c);
            }
        }
        
        return sb.toString();
    }
}