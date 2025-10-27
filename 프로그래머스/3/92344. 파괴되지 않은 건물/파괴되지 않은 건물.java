// 1. skill 순회하면서 변화량 배열 만들기
// 2. 해당 배열로 누적합 진행
// 3. board + 해당 셀의 누적합을 계산해서 1 이상이면 answer + 1

class Solution {
    public int solution(int[][] board, int[][] skills) {
        
        int[][] sum = new int[board.length + 1][board[0].length + 1]; // 누적합을 계산할 배열 (마지막 행, 열 누적합 계산을 위해 길이를 +1씩 늘려줌)
        int answer = 0;
        
        // 누적합 표기
        for(int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];
            
            // 공격이면 -를 붙여줌
            if(type == 1) {
                degree = -degree;
            }
            
            // 누적합 계산을 위한 기준점 갱신
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] += -degree;
            sum[r2 + 1][c1] += -degree;
            sum[r2 + 1][c2 + 1] += degree;
            
        }
        
        // 누적합 계산
        for(int i = 0; i < sum.length; i++) {
            for(int k = 0; k < sum[i].length; k++) {
                int row = i > 0 ? sum[i - 1][k] : 0;
                int col = k > 0 ? sum[i][k - 1] : 0;
                int duplication = (k > 0 && i > 0) ? sum[i - 1][k - 1] : 0;
                
                sum[i][k] += row + col - duplication;
            }
        }
        
        
        for(int i = 0; i < board.length; i++) {
            for(int k = 0; k < board[i].length; k++) {
                if(board[i][k] + sum[i][k] >= 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}