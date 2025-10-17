import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        // N이 사용된 개수별로 가능한 모든 연산 결과를 저장할 Set과 이런 Set들을 관리할 List 선언
        List<Set<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }
        
        // N이 1번 사용되는 경우 초기화
        list.get(1).add(N);
        if(N == number) return 1;
        
        for(int i = 2; i <= 8; i++) {
            
            int temp = 0;
            
            // 숫자 연속으로 붙이기
            for(int j = 0; j < i; j++) {
                temp = temp * 10 + N;
            }
            
            list.get(i).add(temp);
            
            // 더 작은 N들끼리 사칙연산을함
            for(int j = 1; j < i ; j++) {
                for(int x : list.get(j)) {
                    for(int y : list.get(i - j)) {
                        
                        list.get(i).add(x + y);
                        list.get(i).add(x - y);
                        list.get(i).add(x * y);
                        if(y != 0) {
                            list.get(i).add(x / y);
                        }
                        
                    }
                }
            }
            
            if(list.get(i).contains(number)) {
                return i;
            }
            
        }
        
        return -1;
    }
}