import java.util.*;

class Solution {
    
    private boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            
            switch(c) {
                case '}' -> {
                    if(!stack.isEmpty()) {
                        if(stack.peek() == '{') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;    
                    }
                } 
                
                case ']' -> {
                    if(!stack.isEmpty()) {
                        if(stack.peek() == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;    
                    }
                } 
                
                case ')' -> {
                    if(!stack.isEmpty()) {
                        if(stack.peek() == '(') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } 
                    
                default -> {
                    stack.add(c);
                }
            }
        }
        
        return stack.isEmpty();
        
    }
    
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            
            String ss = s.substring(i) + s.substring(0, i);
            
            if(isRight(ss)) {
                answer++;
            }
        }
        
        return answer;
    }
}