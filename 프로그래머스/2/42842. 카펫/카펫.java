class Solution {
    public int[] solution(int brown, int yellow) {
        // 전체 타일의 개수
        int total = brown + yellow;
        
        // 세로 길이(h)는 최소 3부터 시작
        // 제곱근까지만 탐색하여 효율성 극대화
        for (int h = 3; h <= Math.sqrt(total); h++) {
            
            // h가 total의 약수일 때만 카펫을 만들 수 있음
            if (total % h == 0) {
                int w = total / h; // 가로 길이 구하기
                
                // 노란색 타일의 개수 조건이 맞는지 확인
                if ((w - 2) * (h - 2) == yellow) {
                    // 프로그래머스 정답 형식에 맞게 가로, 세로 배열 반환
                    return new int[] {w, h};
                }
            }
        }
        
        // 문제 조건상 항상 답이 존재하므로 사실상 도달하지 않는 코드
        return new int[] {}; 
    }
}