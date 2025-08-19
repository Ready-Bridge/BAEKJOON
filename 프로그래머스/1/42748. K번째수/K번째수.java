import java.util.*;

class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        
        // 결과 배열
        int[] result = new int[commands.length];
        int resultTemp = 0;
        
        for(int s = 0; s < commands.length; s++) {
            
            // 각 상황별 i, j, k
            int i = commands[s][0];
            int j = commands[s][1];
            int k = commands[s][2];
            
            // 자를 size와 담을 배열
            int size = j - i + 1;
            int[] arr = new int[size];
            
            // 인덱스
            int temp = 0;
            
            for(int ss = i - 1; ss <= j - 1; ss++) {
                arr[temp++] = array[ss];
            }
            
            Arrays.sort(arr);
            
            result[resultTemp++] = arr[k - 1];
        }
        
        return result;
    }
}