class Solution {
    public String solution(String s, int v) {
        
        char [] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(char c : arr) {
            
            int n = v;
            
            if(c == ' ') {
                sb.append(" ");
                continue;
            }
            
            if(Character.isLowerCase(c)) {
                if('z' - c < n) {
                    n -= ('z' - c + 1);
                    c = (char)('a' + n);
                } else {
                    c += n;
                }
            } else if(Character.isUpperCase(c)) {
                if('Z' - c < n) {
                    n -= ('Z' - c + 1);
                    c = (char)('A' + n);
                } else {
                    c += n;
                }
            }
            
            sb.append(c);
        }
        
        String answer = sb.toString();
        return answer;
    }
}