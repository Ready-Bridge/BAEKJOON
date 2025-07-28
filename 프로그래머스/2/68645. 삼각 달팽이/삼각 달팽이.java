class Solution {
    
    public int[] solution(int n) {
        
        // pos 가 0이면 밑으로 1이면 오른쪽으로 2면 대각선 위로
        
        int x = -1;
        int y = 0;
        int ans = 1; // 값
        int [][] arr = new int[n][n];
        
        while(true) {
            
            // 밑으로 갈 수 있을 때 까지
            while(true) {
                x += 1;
                arr[x][y] = ans++;

                if(x + 1 == n || arr[x + 1][y] != 0) {
                    break;
                }
            }
            
            if(y + 1 == n || arr[x][y + 1] != 0) {
                break;
            }
            
            // 옆으로 갈 수 있을 때 까지
            while(true) {
                y += 1;
                arr[x][y] = ans++;
                
                if(y + 1 == n || arr[x][y + 1] != 0) {
                    break;
                }
            }
            
            if(arr[x - 1][y - 1] != 0) {
                break;
            }
            
            // 대각선 위로 갈 수 있을 때 까지
            while(true) {
                x -= 1;
                y -= 1;
                
                arr[x][y] = ans++;
                
                if(arr[x - 1][y - 1] != 0) {
                    break;
                }
            }
            
            if(arr[x + 1][y] != 0) {
                break;
            }
        }
        
        int [] answer = new int [ans - 1];
        
        int temp = 0;
        
        for(int [] i : arr) {
            for(int k : i) {
                if(k != 0) {
                    answer[temp++] = k;
                }
            }
        }
        
        return answer;
        
    }
}