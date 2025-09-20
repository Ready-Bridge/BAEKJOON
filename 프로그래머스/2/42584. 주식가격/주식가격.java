import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] result = new int [prices.length];
        
        Stack<Integer> stack = new Stack<>(); // 인덱스 저장
        
        for(int i = 0; i < prices.length; i++) {
            // 현재 가격보다 높은 가격이 스택에 있다면 다 pop
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int temp = stack.pop();
                result[temp] = i - temp;
            }
            stack.push(i);
        }
        
        // 끝까지 안 떨어진 경우 처리
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            result[temp] = prices.length - temp - 1;
        }
        
        return result;
    }
}
