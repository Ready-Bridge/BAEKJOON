import java.util.*;

class Solution {
    
    class Node {
        Map<Integer, Integer> remainNumber = new HashMap<>();
        Map<Character, Node> children = new HashMap<>();
        
        void add(String word, int idx) {
            int length = word.length() - idx;
            remainNumber.put(length, remainNumber.getOrDefault(length, 0) + 1);
            
            if(length > 0) {
                char c = word.charAt(idx);
                Node child = children.getOrDefault(c, new Node());
                child.add(word, idx + 1);
                children.put(c, child);
            }
        }
        
        int find(String query, int idx) {
            if(query.charAt(idx) == '?') {
                return remainNumber.getOrDefault(query.length() - idx, 0);
            }
            
            char c = query.charAt(idx);
            if(!children.containsKey(c)) {
                return 0;
            } else {
                return children.get(c).find(query, idx + 1);
            }
        }
    }
    
    int count(String query, Node trie, Node reverseTrie) {
        if(query.startsWith("?")) {
            return reverseTrie.find(new StringBuilder(query).reverse().toString(), 0);
        } else {
            return trie.find(query, 0);
        }
    }
    
    public int[] solution(String[] words, String[] queries) {
        
        Node trie = new Node();
        Node reverseTrie = new Node();
        
        for(String word : words) {
            trie.add(word, 0);
            reverseTrie.add(new StringBuilder(word).reverse().toString(),0);
        }
        
        return Arrays.stream(queries)
                .mapToInt(query -> count(query, trie, reverseTrie))
                .toArray();
    }
}