import java.util.*;

class Solution {
    
    // 상하좌우
    int[] drow = {-1, 1, 0, 0};
    int[] dcol = {0, 0, -1, 1};
    
    int n, m;
    boolean[][] isHole;
    boolean[][][] isVisit; // [][][0]은 1칸 이동 시, [][][1]은 2칸 이동 시 방문 여부를 나타냄
    
    boolean isRange(int[] arr) {
        int row = arr[0] - 1;
        int col = arr[1] - 1;
        int use = arr[2]; // 1이면 사용 0이면 미사용
        
        // 범위 벗어나면 이동 불가
        if(row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }
        
        // 구덩이면 이동 불가
        if(isHole[row][col]) {
            return false; 
        }
        
        // 해당 지역을 이미 방문했다면 더이상 방문 X
        if(use == 1) {
            if(isVisit[row][col][1]) {
                return false;
            }
        } else {
            if(isVisit[row][col][0]) {
                return false;
            }
        }
            
        return true;
        
    }
    
    public int solution(int n, int m, int[][] hole) {
        
        this.n = n;
        this.m = m;
        
        isHole = new boolean[m][n];
        isVisit = new boolean[m][n][2];
        
        // hole의 위치를 boolean 배열로 나타냄
        for(int i = 0; i < hole.length; i++) {
            
            int row = hole[i][1] - 1;
            int col = hole[i][0] - 1;
            
            isHole[row][col] = true;
        }
        
        // {row, col, use, time}
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 1, 0, 0}); // (1, 1) 부터 시작
        isVisit[0][0][0] = true;
        
        // queue가 비어있지 않다면 계속 탐색
        while(!queue.isEmpty()) {
            
            int[] arr = queue.poll();
            
            // 보물에 도착했으면 이동한 거리 return (BFS이므로 최소거리 보장)
            if(arr[0] == m && arr[1] == n) {
                return arr[3];
            }
            
            // 1칸 이동
            for(int i = 0; i < 4; i++) {
                
                int[] temp = {arr[0] + drow[i], arr[1] + dcol[i], arr[2], arr[3] + 1};
                
                if(isRange(temp)) {
                    queue.add(temp);
                    isVisit[temp[0] - 1][temp[1] - 1][arr[2]] = true;
                }
            }
            
            // 신발 사용한적 없으면 2칸 이동
            if(arr[2] == 0) {
                for(int i = 0; i < 4; i++) {
                    
                    int[] temp = {arr[0] + drow[i] * 2, arr[1] + dcol[i] * 2, arr[2] + 1, arr[3] + 1};
                    
                    if(isRange(temp)) {
                        queue.add(temp);
                        isVisit[temp[0] - 1][temp[1] - 1][1] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}
