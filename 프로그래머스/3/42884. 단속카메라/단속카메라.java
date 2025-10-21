import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        int answer = 0;
        int nowStart = 0; // 현재 차량이 고속도로에 진입한 지점
        int prevEnd = 0; // 이전 차량이 고속도로에서 나간 지점
        
        // 나간 지점, 들어온 지점 순으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        
        // 가장 첫번 째에 오는 차량의 마지막 나가는 지점에 카메라 추가
        prevEnd = routes[0][1];
        answer++;
        
        // routes를 순회하며 카메라 추가
        for(int i = 1; i < routes.length; i++) {
            
            nowStart = routes[i][0];
            
            // 카메라를 추가해야하는 시점
            if(nowStart > prevEnd) {
                answer++;
                prevEnd = routes[i][1];
            }
        }
        
        return answer;
    }
}