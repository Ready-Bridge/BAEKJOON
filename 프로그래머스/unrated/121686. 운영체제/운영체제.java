import java.util.*;

class Solution {
    public long[] solution(int[][] programs) {
        
        Map<Integer, List<int[]>> waitMap = new HashMap<>(); 
        Map<Integer, Long> resultMap = new HashMap<>();
        
        // waitMap 및 resultMap 초기화
        for(int i = 1; i <= 10; i++) {
            waitMap.put(i, new LinkedList<>());
            resultMap.put(i, 0L); 
        }
        
        // programs의 정보를 토대로 대기 프로그램들을 정리함
        for(int[] program : programs) {
            waitMap.get(program[0]).add(new int[] {program[1], program[2]});
        }
        
        // 각 점수별 대기 프로그램들의 호출 시각에 따라 오름차순 정렬
        for(int i = 1; i <= 10; i++) {
            List<int[]> list = waitMap.get(i);
            if (!list.isEmpty()) { // 리스트가 비어있지 않을 때만 정렬
                Collections.sort(list, (a, b) -> a[0] - b[0]);
            }
        }
    
        long nowTime = 0; 
        
        int totalPrograms = programs.length;
        int executedCount = 0;

        while(executedCount < totalPrograms) {
            
            // 이번 턴에 프로그램을 실행했는지 확인하는 플래그
            boolean programExecuted = false; 
            // 실행할 게 없을 때 점프할 다음 도착 시간
            long minNextArrivalTime = Long.MAX_VALUE; 
            
            // 우선순위 1번부터 다시 검색
            for(int i = 1; i <= 10; i++) {
                
                List<int[]> list = waitMap.get(i);
                
                if (list.isEmpty()) {
                    continue;
                }
                
                // 가장 빠른 도착 시간을 minNextArrivalTime에 갱신
                minNextArrivalTime = Math.min(minNextArrivalTime, list.get(0)[0]);
                
                // 도착시간 순 정렬이므로 0번째만 확인하면 됨
                if (list.get(0)[0] <= nowTime) { 
                    
                    // 실행할 프로그램(0번째)을 꺼냄
                    int[] program = list.remove(0); 
                    int arrival = program[0];
                    int execution = program[1];
                    
                    // 대기 시간 계산 및 갱신
                    long waitTime = nowTime - arrival;
                    resultMap.put(i, resultMap.get(i) + waitTime);
                    
                    // 현재 시간 갱신
                    nowTime += execution; 
                    
                    executedCount++; // 실행한 프로그램 수 증가
                    programExecuted = true; // 실행했다고 표시
                    
                    break; 
                }
            } 
            
            // 이번 턴에 실행한 프로그램이 없다면
            if (!programExecuted) {
                // minNextArrivalTime이 MAX_VALUE가 아니어야 함 = 아직 프로그램이 남았음
                if (minNextArrivalTime != Long.MAX_VALUE) {
                    // 현재 시간을 다음 프로그램의 도착 시간으로 점프
                    nowTime = minNextArrivalTime;
                }
            }
            
        } // while 종료
        
        
        // 종료시간, 1번 대기시간, 2번 대기시간, ..
        long[] answer = new long[11];
        
        answer[0] = nowTime; // 모든 작업이 끝난 최종 시간
        
        for(int i = 1; i <= 10; i++) {
            answer[i] = resultMap.get(i);
        }
        
        return answer;
    }
}
