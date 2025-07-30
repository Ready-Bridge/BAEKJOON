class Solution {
    
    static int p;
    
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        // 결과 배열 (arr1의 행 개수 x arr2의 열 개수)
        int[][] result = new int[arr1.length][arr2[0].length];
        
        int sum; // 하나의 셀을 계산하여 저장하는 변수
        
        // arr1의 행을 하나씩 돌기
        for(int i = 0; i < arr1.length; i++) {
            
            // arr2의 열을 하나씩 돌기
            for(int k = 0; k < arr2[0].length; k++) {
                
                sum = 0;
                // arr2의 열 하나에 있는 값들을 각각 arr1의 하나의 행에 있는 값들과 연산
                for(p = 0; p < arr2.length; p++) {
                    sum += (arr1[i][p] * arr2[p][k]);
                }
                
                result[i][k] = sum; 
            }
        }
        
        return result;
    }
}