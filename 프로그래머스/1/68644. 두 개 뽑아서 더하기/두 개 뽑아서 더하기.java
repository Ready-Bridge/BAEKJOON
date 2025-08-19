import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < numbers.length - 1; i++) {
            for(int k = i + 1; k < numbers.length; k++) {
                set.add(numbers[i] + numbers[k]);
            }
        }
        
        int[] result = set.stream()
            .mapToInt(Integer::intValue).toArray();
        
        Arrays.sort(result);
        
        return result;
    }
}