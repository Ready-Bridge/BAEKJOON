import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(arr, (v1, v2) -> (v2 + v1).compareTo(v1 + v2));
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        
        
        String result = sb.toString();
        
        if(result.charAt(0) == '0') {
            return "0";
        } else {
            return result;
        }
    }
}