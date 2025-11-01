class Solution {
    
    // 위쪽, 오른쪽, 아래쪽, 왼쪽 방향벡터
    // R이면 현재 방향(인덱스)를 + 1
    // L이면 현재 방향(인덱스)를 - 1
    
    int[] drow = {1, 0, -1, 0};
    int[] dcol = {0, 1, 0, -1};
    
    public int[] solution(String command) {
        
        int[] start = {0, 0};
        int direction = 0; // 위쪽 바라보고 시작
        
        for(char c : command.toCharArray()) {
            
            if(c == 'R') {
                direction = (direction + 1) % 4;    
            } else if(c == 'L') {
                direction = ((direction - 1) + 4) % 4;
            } else if(c == 'G') {
                start[1] += drow[direction];
                start[0] += dcol[direction];
            } else { // 후진의 경우 현재 방향의 반대로 움직임
                start[1] -= drow[direction];
                start[0] -= dcol[direction];
            }
        }
            
        return start;
    }
}
