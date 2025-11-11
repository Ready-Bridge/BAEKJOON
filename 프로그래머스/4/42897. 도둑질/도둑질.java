class Solution {
    
    public int solution(int[] money) {
        
        int[] home1 = new int[money.length]; // 맨 처음 집 선택했을때 최대값
        int[] home2 = new int[money.length]; // 맨 처음 선택안했을때 최대값
        
        home1[0] = money[0];
        home1[1] = Math.max(home1[0], money[1]);
        home2[1] = money[1];
        
        for(int i = 2; i < money.length - 1; i++) {
            home1[i] = Math.max(home1[i - 2] + money[i], home1[i - 1]);
            home2[i] = Math.max(home2[i - 2] + money[i], home2[i - 1]);
        }
        
        home2[money.length - 1] = Math.max(home2[money.length - 3] + money[money.length - 1], home2[money.length - 2]);
        
        int answer = Math.max(home1[money.length - 2], home2[money.length - 1]);
        return answer;
    }
}