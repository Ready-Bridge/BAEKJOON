import java.util.*;

class Solution {
    
    Set<String> hashSet = new HashSet<>();
    
    public int solution(String numbers) {
        
        for(int c = 0; c < numbers.length(); c++) {
            
            char [] carr = numbers.toCharArray();
            
            if(carr[c] != '0') {
                
                List<String> list = new ArrayList<>();
                
                for(int i = 0 ; i < numbers.length(); i++) {
                    if(i != c) {
                        list.add(String.valueOf(carr[i]));
                    }        
                }
                create(String.valueOf(carr[c]), list);
            }
        }
        
        int cnt = 0;
        
        for(String s : hashSet) {
            
            if(isDecimal(Integer.parseInt(s))) {
                cnt += 1;
            }
        }
        
        return cnt;
    }
    
    private void create(String s, List<String> list) {
        
        hashSet.add(s);
        
        if(list.isEmpty()) {
            return;
        }
        
        for(int i = 0; i < list.size(); i++) {
            
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(list.get(i));
            
            List<String> list2 = new ArrayList<>();
                
            for(int k = 0 ; k < list.size(); k++) {
                if(i != k) {
                    list2.add(list.get(k));
                }        
            }
                
            create(sb.toString(), list2);
        }
    }
    
    private boolean isDecimal(int target) {
        
        if(target == 1) {
            return false;
        }
        
        if(target == 2) {
            return true;
        }
        
        for(int i = 2 ; i <= Math.floor(Math.sqrt(target)) + 1; i++) {
            if(target % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}