import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> (b + a).compareTo((a + b)));
        
        String result = "";
        
        for(int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        
        if(result.charAt(0) == '0') {
            return "0";
        }
        
        return result;
        
    }
}