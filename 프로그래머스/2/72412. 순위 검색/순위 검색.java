import java.util.*;
import java.util.function.*;

class Solution {
    
    private void all(int index, String prefix, String[] tokens, Consumer<String> action) {
        
        if(index == tokens.length - 1) {
            action.accept(prefix);
            return;
        }
        
        all(index + 1, prefix + tokens[index], tokens, action);
        all(index + 1, prefix + "-", tokens, action);
        
    }
    
    private Map<String, List<Integer>> create(String[] info) {
        
        Map<String, List<Integer>> map = new HashMap<>();
        
        for(String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            
            all(0, "", tokens, key -> {
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(score);
            });
        }
        
        for(List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        return map;
    }
    
    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;
        
        while(end > start) {
            int mid = (end + start) / 2;
            
            if(scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        if(scores.get(start) < score) {
            return scores.size();
        }
        
        return start;
    }
    
    private int count(String query, Map<String, List<Integer>> map) {
        
        String[] arr = query.split(" (and)?");
        
        String key = String.join("", Arrays.copyOf(arr, arr.length - 1));
        
        if(!map.containsKey(key)) {
            return 0;
        }
        
        List<Integer> scores = map.get(key);
        
        return scores.size() - binarySearch(Integer.parseInt(arr[arr.length - 1]), scores);
        
    }
    
    public int[] solution(String[] info, String[] query) {
        
        Map<String, List<Integer>> map = create(info);
        
        int [] arr = new int[query.length];
        
        for(int i = 0 ; i < query.length; i ++) {
            arr[i] = count(query[i], map);
        }
        
        return arr;
        
        
    }
}