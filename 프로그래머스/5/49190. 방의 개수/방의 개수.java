import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    
    public class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public String getId() {
            return String.format("(%d, %d)", x, y);
        }
    }
    
    public int solution(int[] arrows) {
        int cnt = 0;
        Map<String, Set<String>> visited = new HashMap<>();
        
        Point now = new Point(0, 0);
        visited.put(now.getId(), new HashSet<>());
        
        for (int d : arrows) {
            // 각 화살표를 2번 쪼갠다 (중간 교차점을 잡기 위해)
            for (int k = 0; k < 2; k++) {
                Point next = new Point(now.x + dx[d], now.y + dy[d]);
                String nowId = now.getId();
                String nextId = next.getId();
                
                // next가 처음 등장하면 새 노드와 양방향 간선 추가
                if (!visited.containsKey(nextId)) {
                    visited.put(nextId, new HashSet<>());
                    // now가 혹시 없을 경우 대비
                    visited.computeIfAbsent(nowId, key -> new HashSet<>());
                    visited.get(nextId).add(nowId);
                    visited.get(nowId).add(nextId);
                } else {
                    // next가 이미 있지만 now와의 간선이 없으면 새로운 방(사이클)이 생긴 것
                    if (!visited.get(nextId).contains(nowId)) {
                        cnt++;
                    }
                    visited.get(nextId).add(nowId);
                    visited.get(nowId).add(nextId);
                }
                
                now = next;
            }
        }
        
        return cnt;
    }
}
