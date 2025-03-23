import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> ans = new ArrayList<>();
        
        ans.add(arr[0]);
        int k = 0;
        
        for(int n : arr) {
            if(ans.get(k) != n) {
                ans.add(n);
                k += 1;
            }
        }
        
        int [] answer = new int[ans.size()];
        int i = 0;
        
        for(int n : ans) {
            answer[i++] = n;
        }
        
        return answer;
    }
}