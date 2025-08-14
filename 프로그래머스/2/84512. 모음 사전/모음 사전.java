import java.util.*;

class Solution {
    
    static String s = "AEIOU";
    
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        dict("", words);
        
        return words.indexOf(word);
    }
    
    
    private void dict(String word, List<String> words) {
        
        words.add(word);
        
        if(word.length() == 5) {
            return;
        }
        
        for(char c : s.toCharArray()) {
            dict(word + c, words);
        }
    }
}