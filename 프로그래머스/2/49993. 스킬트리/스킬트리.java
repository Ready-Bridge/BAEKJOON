class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int cnt = 0;
        boolean flag = false;
        
        char[] skillArray = skill.toCharArray();
        
        for(int j = 0; j < skill_trees.length; j++) {
            
            int idx = 0;
            
            for(char c : skill_trees[j].toCharArray()) {
                
                int temp = -1;
                flag = false;
                
                for(int i = 0; i < skillArray.length; i++) {
                    if(c == skillArray[i]) {
                        temp = i;
                    }
                }
                
                if(temp != -1) {
                    if(idx != temp) {
                        flag = true;
                        break;
                    } else {
                        idx++;
                    }
                }
            }
            
            if(!flag) {
                cnt++;
            }
        }
        
        return cnt;
    }
}