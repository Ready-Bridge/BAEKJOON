class Solution {
    
    // 상하좌우 방햑벡터
    int[] dRow = {-1, 1, 0 ,0};
    int[] dCol = {0, 0, -1, 1};
    
    boolean isRange(int row, int col, int[][] board) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if(board[row][col] == 0) {
            return false;
        }
        return true;
    }
    
    // 반환값: {승리 여부(0: 승리, 1: 패배), 턴 수}
    int[] dfs(int[] me, int[] opponent, int[][] board) {
        
        int meRow = me[0];
        int meCol = me[1];
        
        // 현재 내 발판이 없어지면 패배
        if(board[meRow][meCol] == 0) {
            return new int[] {1, 0}; // {패배, 0턴}
        }
        
        // winTurn은 최소값을 찾아야 하므로 큰 값으로 초기화
        int winTurn = 26; // 최대 5 * 5 이므로 26으로 초기화
        // loseTurn은 최대값을 찾아야 하므로 작은 값으로 초기화
        int loseTurn = 0; 
        boolean canWin = false; // 이길 수 있는지 체크
        boolean canMove = false; // 움직일 수 있는지 체크
        
        board[meRow][meCol] = 0; // 발판 삭제
        
        for(int d = 0; d < 4; d++) {
            int newRow = meRow + dRow[d];
            int newCol = meCol + dCol[d];
            
            if(!isRange(newRow, newCol, board)) continue; 
            
            canMove = true; // 한 번이라도 움직일 수 있음
            
            int[] result = dfs(opponent, new int[] {newRow, newCol}, board);
            
            // result[0] == 1 (상대방 패배) -> 나는 승리
            if(result[0] == 1) { 
                winTurn = Math.min(winTurn, result[1]);
                canWin = true;
            } else { // result[0] == 0 (상대방 승리) -> 나는 패배
                loseTurn = Math.max(loseTurn, result[1]);
            }
        }
        
        board[meRow][meCol] = 1; // 발판 복구
        
        // 움직일 곳이 없어서 졌을 경우
        if(!canMove) {
            return new int[] {1, 0}; // {패배, 0턴}
        }

        if(canWin) {
            return new int[] {0, winTurn + 1}; // 내 턴(+1) 포함 
        } else {
            return new int[] {1, loseTurn + 1}; // 내 턴(+1) 포함
        }
    }
        
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        
        int[] result = dfs(aloc, bloc, board);
        
        return result[1];
    }
}