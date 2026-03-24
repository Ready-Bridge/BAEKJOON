import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }
        
        for(int i = 0; i < phone_book.length; i++) {
            for(int k = 1; k < phone_book[i].length(); k++) {
                
                String word = phone_book[i].substring(0, k);
                
                if(map.containsKey(word)) return false;
                
            }
        }
        
        return true;
        
    }
}