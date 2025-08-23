import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            combination(chars, 0, "");
        }
        
        List<String> result = new ArrayList<>();
        
        for (int len : course) {
            int max = 2; 
            List<String> temp = new ArrayList<>();
            
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                
                if (key.length() == len) {
                    if (value == max) {
                        temp.add(key);
                    } else if (value > max) {
                        temp.clear();
                        temp.add(key);
                        max = value;
                    }
                }
            }
            result.addAll(temp);
        }
        
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    
    private void combination(char[] arr, int idx, String curr) {
        if (curr.length() >= 2) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
        for (int i = idx; i < arr.length; i++) {
            combination(arr, i + 1, curr + arr[i]);
        }
    }
}
