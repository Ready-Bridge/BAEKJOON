class Solution {
    
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    public int[] solution(String[][] places) {
        
        int [] result = new int[places.length];
        
        // 대기실 반복
        for(int k = 0; k < places.length; k++) {
            
            char [][] arr = new char[places[k].length][];
            
            // char 배열로 변환
            for(int i = 0; i < arr.length; i++) {
                arr[i] = places[k][i].toCharArray();
            }
            
            // 거리두기 준수 여부를 확인해주는 isFollwed 함수 호출
            if(isFollowed(arr)) {
                result[k] = 1;
            } else {
                result[k] = 0;
            }
            
        }
        
        return result;
        
    }
    
    // 거리두기 준수 여부 확인
    private boolean isFollowed(char[][] arr) {
        
        for(int i = 0; i < arr.length; i++) {
            for(int k = 0; k < arr[i].length; k++) {
                if(arr[i][k] != 'P') {
                    continue;
                }
                
                // P인 경우만 거리두기 확인
                if(!isFollowed(arr, k, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isFollowed(char[][] arr, int x, int y) {
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(ny < 0 || ny >= arr.length || nx < 0 || nx >= arr[ny].length) {
                continue;
            }
            
            // 멘헤튼 거리 1인데 응시자(P) 있으면 규칙 준수 X
            if(arr[ny][nx] == 'P') {
                return false;
            } 
            
            // 만약 빈 테이블(O) 있으면 멘헤튼 거리 2도 확인해봐야함 (현재 방향 제외해야하므로 방향도 같이 넘겨줘야함)
            else if(arr[ny][nx] == 'O') {
                // i는 방향
                if(isNextFollowed(arr, nx, ny, i)) {
                    return false;
                }
            }
            
            // 파티션(X) 있으면 스킵하고 다른 방향 찾아봐도됨
        }
        
        return true;
    }
    
    private boolean isNextFollowed(char[][] arr, int x, int y, int direction) {
        
        switch(direction) {
            case 0 : direction = 1;
                break;
            case 1 : direction = 0;
                break;
            case 2 : direction = 3;
                break;
            case 3 : direction = 2;
                break;
        }
        
        for(int i = 0; i < 4; i++) {
            if(i != direction) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(ny < 0 || ny >= arr.length || nx < 0 || nx >= arr[ny].length) {
                    continue;
                }
                
                if(arr[ny][nx] == 'P') {
                    return true;
                }
            }
        }
        
        return false;
    }
}