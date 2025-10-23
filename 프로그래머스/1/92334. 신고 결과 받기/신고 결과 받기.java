import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Set<String> set = new HashSet<>();
        Map<String, List<String>> reportMap = new HashMap<>(); // 각 유저별 신고 당한 목록
        Map<String, Integer> resultMap = new HashMap<>(); // 처리 결과 메일을 받을 수
        
        for(int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new ArrayList<>());
            resultMap.put(id_list[i], 0);
        }
        
        // report의 중복 신고 제거
        for(int i = 0; i < report.length; i++) {
            set.add(report[i]);
        }
        
        for(String s : set) {
            
            String[] temp = s.split(" ");
            reportMap.get(temp[1]).add(temp[0]);
        }
        
        // 신고 횟수 k 넘은 유저를 신고한 모든 이용자에게 처리 결과 메일 개수를 +1 해줌
        for(Map.Entry<String, List<String>> entrySet : reportMap.entrySet()) {
            
            List<String> list = entrySet.getValue();
            
            if(list.size() >= k) {
                for(int i = 0; i < list.size(); i++) {
                    resultMap.put(list.get(i), resultMap.get(list.get(i)) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = resultMap.get(id_list[i]);
        }
        
        return answer;
    }
}