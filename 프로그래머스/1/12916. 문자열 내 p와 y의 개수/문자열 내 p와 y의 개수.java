class Solution {
    boolean solution(String s) {
        
        int y = 0;
        int p = 0;
        
        for(char c : s.toCharArray()) {
            if(c == 'p' || c == 'P') {
                p++;
            } else if(c == 'y' || c == 'Y') {
                y++;
            }
        }
        
        if(p == y) {
            return true;
        } else {
            return false;
        }
    }
}