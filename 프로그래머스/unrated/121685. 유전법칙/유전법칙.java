class Solution {
    
    String find(int n, int p) {
        
        if(n == 1) {
            return "Rr";
        }
        
        int group = p / (int)Math.pow(4, n - 2);
        
        if(group == 0) {
            return "RR";
        }
        
        if(group == 3) {
            return "rr";
        }
        
        return find(n - 1, p % (int)Math.pow(4, n - 2));
        
    }
    
    public String[] solution(int[][] queries) {
        
        String[] answer = new String[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            
            answer[i] = find(queries[i][0], queries[i][1] - 1);
        }
        
        return answer;
    }
}
