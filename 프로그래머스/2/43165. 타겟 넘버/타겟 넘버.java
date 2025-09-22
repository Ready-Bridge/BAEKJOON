class Solution {
    
    int cnt = 0;
    
    private void dfs(int sum, int idx, int[] numbers, int target) {
        if(idx == numbers.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }
        
        dfs(sum + numbers[idx], idx + 1, numbers, target);
        dfs(sum - numbers[idx], idx + 1, numbers, target);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return cnt;
    }
}