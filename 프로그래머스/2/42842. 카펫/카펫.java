class Solution {
    public int[] solution(int brown, int yellow) {
        
        if(yellow == 1 && brown == 8) {
            return new int[] {3, 3};
        }
        
        for(int i = 1; i <= yellow / 2; i++) {
            if(yellow % i == 0) {
                int height = i;
                int width = yellow / i;
                
                int isBrown = ((width + 2) * 2) + (height * 2);
                
                if(brown == isBrown) {
                    return new int[] {width + 2, height + 2};
                }
            }
        }
        
        return new int[] {-1, -1};
    }
}