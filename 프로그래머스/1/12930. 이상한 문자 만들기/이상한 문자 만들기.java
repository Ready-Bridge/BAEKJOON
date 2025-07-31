class Solution {
    public String solution(String s) {
        
        char [] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0; // 각 단어 length 를 위한 변수
        int t = 0; // arr에 접근할 index
        
        
        while(t < arr.length) {
            
            if(arr[t] == ' ' && t < arr.length) {
                i = 0;
                t++;
                sb.append(" ");
            }
            
            while(t < arr.length && arr[t] != ' ' ) {
                
                // 단어의 짝수 인덱스면
                if(i % 2 == 0) {
                    sb.append(Character.toUpperCase(arr[t]));
                    t++;
                } else { // 단어의 홀수 인덱스면
                    sb.append(Character.toLowerCase(arr[t]));
                    t++;
                }
                
                i++;
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}