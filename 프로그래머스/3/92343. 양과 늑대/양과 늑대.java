import java.util.*;

class Solution {
    
    int max = -1;
    int[] infoArr;
    
    List<List<Integer>> tree = new ArrayList<>();
    
    void dfs(int sheep, int wolf, List<Integer> nextNodes) {
        
        // 현재 양의 개수가 max보다 많다면 갱신
        max = Math.max(max, sheep);
        
        // 다음에 이동 가능한 (자식)노드들로 전개
        for(int i = 0; i < nextNodes.size(); i++) {
            
            int nextNode = nextNodes.get(i);
            int newSheep = sheep;
            int newWolf = wolf;
            
            
            // 다음 노드가 0이면 양
            if(infoArr[nextNode] == 0) {
                newSheep++;
            } else { // 1이면 늑대
                newWolf++;
            }
            
            // wolf가 잡아먹으면 그 뒤의 탐색은 의미 X
            if(newWolf >= newSheep) continue;
            
            List<Integer> newNextNodes = new ArrayList<>(nextNodes);
            
            // 다음 방문할 노드(현재 i가 가리키는 노드)는 앞으로 방문할 노드에서 제거해줌
            newNextNodes.remove(i);
            
            // 다음 방문할 노드(현재 i가 가리키는 노드)에서 방문할 자식들을 앞으로 방문할 노드에 추가해줌
            newNextNodes.addAll(tree.get(nextNode));
            
            dfs(newSheep, newWolf, newNextNodes);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        
        infoArr = info;
        
        // 각 node별로 ArrayList 초기화
        for(int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }
        
        // 각 node별로 갈 수 있는 자식 node 번호를 저장해둠
        for(int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }
        
        // 루트 노드(양 1마리) 부터 시작
        dfs(1, 0, tree.get(0)); 
        
        return max;
    }
}