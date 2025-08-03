class Solution {
    public int solution(int n) {
        
        String s = Integer.toString(n, 3); // 3진법으로 String 변환
        
        StringBuilder sb = new StringBuilder(s); // StringBuilder 객체 생성
        sb.reverse(); // 뒤집기
        
        int result = Integer.parseInt(sb.toString(), 3);
        
        return result;
        
    }
}