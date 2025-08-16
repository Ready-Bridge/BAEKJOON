import java.util.*;

class Solution {
    
    String [][] arr = {
            {"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "*", "+"},
            {"-", "+", "*"},
            {"*", "-", "+"},
            {"*", "+", "-"},
        };
    
    public long solution(String expression) {
        
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        
        List<String> list = new ArrayList<>();
        
        while(st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        
        long max = Integer.MIN_VALUE;
        
        for(String [] s : arr) {
            long result = Math.abs(calculate(new ArrayList<>(list), s));
            
            if(max < result) {
                max = result;
            }
        }
        
        return max;
    }
    
    // 왼쪽 수와 오른쪽 수 연산자로 연산
    private long calculate(long l, long r, String op) {
        return switch(op) {
            case "+" -> l + r;
            case "-" -> l - r;
            case "*" -> l * r;
            default -> 0;
        };
    }
    
    private long calculate(List<String> l, String[] s) {
        for(String op : s) {
            for(int i = 0; i < l.size(); i++) {
            if(l.get(i).equals(op)) {
                long left = Long.parseLong(l.get(i - 1));
                long right = Long.parseLong(l.get(i + 1));
                long result = calculate(left, right, op);
                
                l.remove(i - 1);
                l.remove(i - 1);
                l.remove(i - 1);
                l.add(i - 1, String.valueOf(result));
                
                i -= 2;
                
                }
            }
        }
        
        return Long.parseLong(l.get(0));
    }
}