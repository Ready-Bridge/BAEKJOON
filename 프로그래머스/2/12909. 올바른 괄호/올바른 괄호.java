import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                if(c == ')') return false;
                stack.add(c);
            } else {
                if(c != stack.peek()) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        
        if(!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}