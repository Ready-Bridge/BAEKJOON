import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (char c : number.toCharArray()) {
            // 뒤의 숫자가 현재보다 크면 앞의 작은 숫자를 제거
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // 아직 다 못 지운 경우, 뒤에서 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 결과 만들기
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        return sb.toString();
    }
}
