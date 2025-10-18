import java.util.*;

class Solution {
    
    int[][] maps;

    // 상, 하, 좌, 우 이동
    int[] drow = {-1, 1, 0, 0};
    int[] dcol = {0, 0, -1, 1};

    // 현재 위치까지의 최단 거리를 저장할 2차원 배열
    int[][] distance;

    boolean isRange(int row, int col, int N, int M) {
        // 1. 맵 범위 내에 있는지 확인
        if (row < 0 || row >= N || col < 0 || col >= M) {
            return false;
        }
        // 2. 벽(1)이 아닌지 확인
        if (maps[row][col] == 0) { // maps에서 0이 이동 가능, 1이 벽
            return false; 
        }
        // 3. 아직 방문하지 않은 곳인지 확인 (거리가 0인 경우 처음 방문)
        if (distance[row][col] != 0) {
            return false;
        }

        return true;
    }

    public int solution(int[][] maps) {
        
        this.maps = maps;
        
        int N = maps.length;
        int M = maps[0].length;

        distance = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        // 시작점 (0, 0)
        q.add(new int[] {0, 0});
        distance[0][0] = 1; // 시작점의 거리는 1로 설정

        while(!q.isEmpty()) {

            int[] d = q.poll(); // 현재 위치 {row, col}
            int currentRow = d[0];
            int currentCol = d[1];

            // 1. 도착점 (N-1, M-1)에 도달했는지 확인
            if(currentRow == N - 1 && currentCol == M - 1) {
                return distance[currentRow][currentCol]; // 도착점의 거리가 최단 거리
            }

            // 2. 4방향 탐색
            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + drow[i];
                int nextCol = currentCol + dcol[i];

                if(isRange(nextRow, nextCol, N, M)) {
                    distance[nextRow][nextCol] = distance[currentRow][currentCol] + 1;
                    q.add(new int[] {nextRow, nextCol});
                }
            }
        }

        // 큐가 비워졌는데 도착점에 도달하지 못했으면, 갈 수 없다는 뜻
        return -1;
    }
}