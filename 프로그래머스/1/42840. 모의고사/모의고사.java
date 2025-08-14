import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int max = -1;
        
        int [][] arr = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            
            int cnt = 0;
            
            for(int k = 0; k < answers.length; k++) {
                if(answers[k] == arr[i][k % (arr[i].length)]) {
                    cnt++;
                }
            }
            
            if(max == cnt) {
                list.add(i + 1);
            }  else if(max < cnt) {
                max = cnt;
                list.clear();
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}