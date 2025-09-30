class Solution {
    public int solution(int n, int[][] results) {
        
        int answer = 0;
        
        boolean[][] graph = new boolean[n][n];
        
        for(int[] arr : results) {
            
            int winner = arr[0] - 1;
            int loser = arr[1] - 1;
            
            graph[winner][loser] = true;
        }
        
        // 연관관계 반영해주기
        for(int middle = 0; middle < n; middle++) {
            for(int start = 0; start < n; start++) {
                for(int end = 0; end < n; end++) {
                    if(graph[start][middle] && graph[middle][end]) {
                        graph[start][end] = true;
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            
            int sum = 0;
            
            for(int k = 0; k < n; k++) {
                if(graph[i][k]) sum += 1;
                if(graph[k][i]) sum += 1;
            }
            
            if(sum == n - 1) {
                answer += 1;
            }
        }
        return answer;
    }
}