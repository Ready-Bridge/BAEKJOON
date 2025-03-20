import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int ans = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] S : clothes) {
            map.put(S[1], map.getOrDefault(S[1], 0) + 1);
        }
        
        for(String S : map.keySet()) {
            ans *= (map.get(S) + 1);
        }
        
        return ans - 1;
    }
}