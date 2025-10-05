import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalGemCount = gemTypes.size();
        
        Map<String, Integer> currentGems = new HashMap<>();
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int end = 0; end < gems.length; end++) {
            
            currentGems.put(gems[end], currentGems.getOrDefault(gems[end], 0) + 1);

            while (currentGems.size() == totalGemCount) {
                
                if (end - start < minLength) {
                    minLength = end - start;
                    result[0] = start + 1;
                    result[1] = end + 1;
                }
                
                currentGems.put(gems[start], currentGems.get(gems[start]) - 1);
                if (currentGems.get(gems[start]) == 0) {
                    currentGems.remove(gems[start]);
                }
                
                start++;
            }
        }
        
        return result;
    }
}