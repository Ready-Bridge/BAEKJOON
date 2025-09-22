import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int[] days = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            days[i] = (remain + speeds[i] - 1) / speeds[i];
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int d : days) queue.add(d);
        
        int temp = queue.poll();
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            if (temp >= queue.peek()) {
                cnt++;
                queue.poll();
            } else {
                list.add(cnt);
                cnt = 1;
                temp = queue.poll();
            }
        }
        
        list.add(cnt);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
