import java.util.*;

class Solution {
    
    private void count(int index, Set<String> banned, String[][] banned_id, Set<Set<String>> ban) {
        
        if(index == banned_id.length) {
            ban.add(new HashSet<>(banned));
            return;
        }
        
        for(String id : banned_id[index]) {
            if(banned.contains(id)) {
                continue;
            }
            
            banned.add(id);
            count(index + 1, banned, banned_id, ban);
            banned.remove(id);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        
        // 해당 banned_id에 가능한 user_id가 전부 저장되어있음
        
        String [][] bans = Arrays.stream(banned_id)
            .map(banned -> banned.replace("*", "."))
            .map(banned -> Arrays.stream(user_id)
                .filter(id -> id.matches(banned))
                .toArray(String[]::new))
            .toArray(String[][]::new);
        
        Set<Set<String>> ban = new HashSet<>();
        
        count(0, new HashSet<>(), bans, ban);
        
        return ban.size();
        
    }
}