class Solution {
    
    int answer;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        boolean[] visited = new boolean[n]; // 방문 여부 체크
        
        // 0번 컴퓨터부터 마지막 컴퓨터까지 순회
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터를 만났다면 새로운 덩어리 발견!
            if (!visited[i]) {
                answer++; // 네트워크 개수 1 증가
                dfs(i, computers, visited); // 연결된 모든 컴퓨터를 찾아 방문 처리
            }
        }
        
        return answer;
    }
    
    private void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true; // 현재 노드 방문 처리
        
        // 인접 행렬을 돌며 현재 노드와 연결된 다른 노드를 찾음
        for (int i = 0; i < computers.length; i++) {
            // 나 자신이 아니고, 연결되어 있으며, 아직 방문 안 한 노드라면 파고들기
            if (i != node && computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers, visited); 
            }
        }
    }
}