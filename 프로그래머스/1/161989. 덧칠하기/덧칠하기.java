class Solution {
    public int solution(int n, int m, int[] section) {
        int cnt = 0;
        int tmp = 0;
        
        for(int i : section) {
            if(i > tmp) {
                tmp = (i + m - 1);
                cnt += 1;
            }
        }
        
        return cnt;
    }
}