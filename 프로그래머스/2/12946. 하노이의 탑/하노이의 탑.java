import java.util.*;

class Solution {
    
    public int[][] solution(int n) {
        
        return hanoi(n, 1, 3).toArray(new int[0][]);
    }
    
    private List<int[]> hanoi(int n, int from, int to) {
        
        // 옮길 원판이 1개이면 그냥 옮기면됨
        if(n == 1) {
            return List.of(new int[] {from, to});
        }
        
        List<int[]> list = new ArrayList<>();
        
        int empty = 6 - from - to;
        
        list.addAll(hanoi(n - 1, from , empty));
        list.addAll(hanoi(1, from , to));
        list.addAll(hanoi(n - 1, empty , to));
        
        return list;
        
    }
}