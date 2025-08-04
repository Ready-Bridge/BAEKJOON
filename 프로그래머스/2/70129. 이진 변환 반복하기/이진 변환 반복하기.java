class Solution {
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        String ss = s;
        
        int tcnt = 0; // 이진 변환 횟수
        int dcnt = 0; // 0 제거 횟수
        boolean flag = true; // 이진 횟수 추가 실행 여부
        
        while(flag) {
            
            if(ss.equals("1")) {
                flag = false;
                break;
            }
            
            char [] arr = ss.toCharArray(); // char 배열로 변환
            tcnt ++; // 이진 변환 횟수 증가
            
            StringBuilder sb = new StringBuilder();
            
            for(char i : arr) {
                
                if(i == '0') {
                    dcnt ++;
                } else {
                    sb.append(i);
                }
            }
            
            ss = Integer.toString(sb.length(), 2);
        }
        
        answer[0] = tcnt;
        answer[1] = dcnt;
        
        return answer;
        
    }
}