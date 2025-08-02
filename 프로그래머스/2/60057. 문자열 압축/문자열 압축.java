import java.util.*;

class Solution {
    
    private int compress(String s, int length) {
        
        StringBuilder sb = new StringBuilder();
        String last = "";
        int cnt = 1; // 같은 문자열 개수
        
        
        for(String token : split(s, length)) {
            if(token.equals(last)) {
                cnt++;
            } else {
                if(cnt > 1) {
                    sb.append(cnt);
                    cnt = 1;
                }
                
                sb.append(last);
                last = token;
            }
        }
        
        if(cnt > 1) {
            sb.append(cnt);
        }
        
        sb.append(last);
        
        return sb.length();
    }
    
    private List<String> split(String s, int length) {
        
        List<String> arr = new ArrayList();
        
        for(int startindex = 0; startindex < s.length(); startindex += length) {
            int endindex = startindex + length;
            if(endindex > s.length()) {
                endindex = s.length();
            }
            
            String temp = s.substring(startindex, endindex);
            arr.add(temp);
        }
        
        return arr;
    }
    
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i <= s.length(); i++) {
            int compressed = compress(s, i);
            if(compressed < min) {
                min = compressed;
            }
        }
        
        return min;
    }
}