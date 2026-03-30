import java.util.*;

class Solution {
    int maxCount = 0;
    
    void dfs(int k, int[][] dungeons, int cnt, boolean[] isVisited) {
        // DFS가 호출될 때마다(즉, 던전을 하나 더 방문할 때마다) 최댓값 갱신
        maxCount = Math.max(maxCount, cnt);
        
        for(int j = 0; j < dungeons.length; j++) {
            // 이미 방문했거나, 남은 피로도가 최소 필요 피로도보다 작으면 패스
            if(isVisited[j]) continue;
            if(k < dungeons[j][0]) continue;
            
            // 방문 처리 후 다음 뎁스로 재귀 호출
            isVisited[j] = true;
            dfs(k - dungeons[j][1], dungeons, cnt + 1, isVisited);
            // 백트래킹 (다른 경로 탐색을 위해 방문 처리 해제)
            isVisited[j] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        boolean[] isVisited = new boolean[dungeons.length];
        
        // 탐색 시작 (파라미터: 초기 피로도, 던전 배열, 현재 방문 횟수, 방문 배열)
        dfs(k, dungeons, 0, isVisited);
        
        return maxCount;
    }
}