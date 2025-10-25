class Solution {
    
    int[] maxArr = new int[11];
    int max = Integer.MIN_VALUE;

    // lion과 apeach의 점수차이를 반환하는 함수
    int diff(int[] lion, int[] apeach) {
        int diff = 0;
        
        for(int i = 0; i < 11; i++) {
            
            if(apeach[i] == 0 && lion[i] == 0) continue;
            
            if(apeach[i] >= lion[i]) {
                diff -= (10 - i); // 어피치가 점수 획득
            } else {
                diff += (10 - i); // 라이언이 점수 획득
            }
            
        }
        
        return diff;
    }
    
    // 새 배열이 기존 배열보다 우선순위가 높은지를 반환하는 함수
    boolean isPriority(int[] existArr, int[] newArr) {
        for(int i = 10; i >= 0; i--) {
            
            if(existArr[i] == newArr[i]) continue;
            
            return existArr[i] < newArr[i];
        }
        
        return false;
    }
    
    void dfs(int idx, int[] hits, int n, int[] apeach) {
        
        // 0점 과녁(idx=10)까지 탐색을 완료한 경우
        if(idx == 10) {
           
            // 남은 화살(n)은 모두 0점 과녁에 쏘는걸로 간주
            hits[10] = n;
            
            int currentDiff = diff(hits, apeach);
            
            // 라이언이 이긴 경우(diff > 0)에만 결과 갱신
            if(currentDiff > 0) {
                
                // 최대 점수 차이보다 큰 경우
                if(currentDiff > max) {
                    max = currentDiff;
                    maxArr = hits.clone(); // 배열을 복사해서 저장
                } 
                // 최대 점수 차이와 같은 경우는 우선순위 비교
                else if (currentDiff == max && isPriority(maxArr, hits)) {
                    maxArr = hits.clone();
                }
            }
            
            // 0점에 쐈던 화살을 다시 0으로 초기화
            // 이전 재귀 단계로 돌아가서 '포기'하는 경우를 탐색해야 하므로
            hits[10] = 0; 
            return; 
        }
        
        // 현재 idx의 점수를 '이기는' 경우
        int arrowsNeeded = apeach[idx] + 1; // 이기기 위해 필요한 화살
        if(n >= arrowsNeeded) { // 남은 화살이 충분하면
            hits[idx] = arrowsNeeded;
            dfs(idx + 1, hits, n - arrowsNeeded, apeach);
            hits[idx] = 0; // 쐈던 화살을 0으로 초기화
        }
        
        // 현재 idx의 점수를 포기하는 경우 (0발 쏨)
        dfs(idx + 1, hits, n, apeach); // 다음 점수(idx+1) 탐색
    }
    
    public int[] solution(int n, int[] info) {
        
        dfs(0, new int[11], n, info);
        
        // 탐색이 끝났는데 max가 갱신되지 않았다면 라이언이 이길 수 없는 경우
        if(max == Integer.MIN_VALUE) {
            
            return new int[]{-1};
            
        } else {
            
            return maxArr;
        }
    }
}